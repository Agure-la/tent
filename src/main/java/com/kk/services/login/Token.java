package com.kk.services.login;

import java.time.Duration;

public class Token {

    public final String accessToken;
    public final Duration accessExpiration;
    public final String refreshToken;
    public final Duration refreshExpiration;

    public Token(String accessToken, Duration accessExpiration,
                 String refreshToken, Duration refreshExpiration) {
        this.accessToken = accessToken;
        this.accessExpiration = accessExpiration;
        this.refreshToken = refreshToken;
        this.refreshExpiration = refreshExpiration;
    }
}
