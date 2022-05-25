package com.kk.services.login;

import com.kk.exceptions.MissingRefreshTokenException;
import com.kk.exceptions.MissingUserException;
import com.kk.exceptions.UnknownError;
import com.kk.model.SystemUser;
import com.kk.model.UserRole;
import com.kk.services.user.UserService;
import io.quarkus.redis.client.RedisClient;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Named("local")
@ApplicationScoped
public class LocalLoginService implements LoginService{

    @Inject
    Logger logger;
    @Inject
    UserService userService;
    @Inject
    //verifies web token
    JWTParser parser;
    @Inject
    //used for caching and as temporary database
    RedisClient redisClient;
    @ConfigProperty(name = "tents.id")
    String tenantsSystemId;
    @ConfigProperty(name = "login_service.local.access_token_expiry", defaultValue = "900")
    Duration accessTokenExpiry;
    @ConfigProperty(name = "login_service.local.refresh_token_expiry", defaultValue = "172800")
    Duration refreshTokenExpiry;
    private String BASE;

    @PostConstruct
    public void init(){
        BASE = "%s:tents_user_login:".formatted(tenantsSystemId);
    }


    @Override
    public Token login(String username, String password) {

        final SystemUser user = userService.findUser(username, password).
                orElseThrow(() -> new MissingUserException(username));
       final String accessToken = buildAccessJwt(user, accessTokenExpiry);
        final String refreshJwt = buildRefreshJwt(user.getUsername(), refreshTokenExpiry);
        redisClient.setex(BASE + "access:" + username, "" + accessTokenExpiry.toSeconds(), accessToken);
        redisClient.setex(BASE + "refresh:" + username, "" + refreshTokenExpiry.toSeconds(),refreshJwt);

        return new Token(accessToken, accessTokenExpiry, refreshJwt, refreshTokenExpiry);
    }

    @Override
    public Token loginAsGuest(String username) {
        final String accessToken = buildAccessJwt(username, accessTokenExpiry);
        final String refreshJwt = buildRefreshJwt(username, refreshTokenExpiry);
        redisClient.setex(BASE + "Access:" + username, refreshJwt,
                "" + accessTokenExpiry.toSeconds());
        redisClient.setex(BASE + "refresh:" + username, refreshJwt,
                "" + refreshTokenExpiry.toSeconds());

        return new Token(accessToken, accessTokenExpiry, refreshJwt, refreshTokenExpiry);
    }

    @Override
    public Token refresh(String refreshToken) {
        final JsonWebToken token;
        try {
            token = parser.parse(refreshToken);
            String username = token.getClaim("samis.user.username");
            if (!redisClient.exists(List.of(BASE + "refresh:" + username)).toBolean()){
                throw new MissingRefreshTokenException(refreshToken);
            }
            final SystemUser user = userService.findUser(username)
                    .orElseThrow(() -> new MissingUserException(username));
            final String accessToken = buildAccessJwt(user, accessTokenExpiry);
            final String refreshJwt = buildRefreshJwt(user.getUsername(), refreshTokenExpiry);
            redisClient.setex(BASE + "access:" + username, refreshJwt,
                    "" + accessTokenExpiry.toSeconds());
            redisClient.setex(BASE + "refresh:" + username, refreshJwt,
                    "" + refreshTokenExpiry.toSeconds());
            return new Token(accessToken, accessTokenExpiry, refreshJwt, refreshTokenExpiry);
        }catch (ParseException e){
            throw new MissingRefreshTokenException(refreshToken);
        }catch (Throwable e){
            //logger.error("Unexpected error", e);
            throw new UnknownError(e);
        }
    }

    @Override
    public void logout(String refreshToken) {
        final JsonWebToken token;
        try {
            token = parser.parse(refreshToken);
            String username = token.getClaim("tents.user.username");
            redisClient.del(List.of(BASE + "access:" + username, BASE + "refresh:" + username));
        } catch (io.smallrye.jwt.auth.principal.ParseException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public String buildAccessJwt(SystemUser user, Duration duration){
        JwtClaimsBuilder claimsBuilder = Jwt.claims().
                issuer("").
                preferredUserName(user.getUsername()).
                subject(user.getUsername()).
                upn(user.getFullName())
                .claim("tents.user.username", user.getUsername())
                .claim("tents.user.username", user.getId())
                .issuedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC))
                .claim("email", user.getEmail())
                .claim("tents.phone_no", user.getPhoneNo())
                .audience(Set.of("", ""))
                .groups(user.getUserRoles().stream().map(UserRole::getRoleName)
                        .collect(Collectors.toSet()));
        if (duration != null){
            claimsBuilder = claimsBuilder.expiresIn(accessTokenExpiry);
        }
        return claimsBuilder.innerSign().encrypt();
    }

    public String buildAccessJwt(String guest, Duration duration){
        final Set<UserRole> roles = userService.findRole("guest")
                .stream().collect(Collectors.toSet());
        final SystemUser systemUser = new SystemUser();
        systemUser.setId(-1L);
        systemUser.setUsername(guest);
        systemUser.setUserRoles(roles);
        return buildAccessJwt(systemUser, duration);
    }

    String buildRefreshJwt(String username, Duration duration) {
        JwtClaimsBuilder claimsBuilder = Jwt.claims()
                .issuer("")
                .subject(username)
                .claim("tents.user.username", username)
                .issuedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC))
                .audience(Set.of("", ""));
        if (duration != null) {
            claimsBuilder = claimsBuilder.expiresIn(duration);
        }
        return claimsBuilder.innerSign().encrypt();
    }
}
