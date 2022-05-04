package com.kk.services.user;

import com.kk.exceptions.DuplicateResourceExecption;
import com.kk.exceptions.ResourceNotFoundException;
import com.kk.model.SystemUser;
import com.kk.model.UserRole;
import com.kk.repository.user.SystemUserRepository;
import com.kk.repository.user.UserRoleRepository;
import io.quarkus.runtime.StartupEvent;
import org.hibernate.DuplicateMappingException;
import org.hibernate.search.mapper.orm.session.SearchSession;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.logging.Logger;

@Singleton
public class UserSvc implements UserService{

    @Inject
    Logger logger;
    @Inject
    SearchSession searchSession;
    @Inject
    SystemUserRepository systemUserRepository;
    @Inject
    UserRoleRepository userRoleRepository;

    @Transactional
    void onStart(@Observes StartupEvent ev) throws InterruptedException{
        //only reindex if we imported sone content
        if (systemUserRepository.count() > 0){
            logger.info("Reindexing users");
            searchSession.massIndexer().startAndWait();
        }
    }
    @Override
    @Transactional
    public SystemUser createUser(String username, String email, String password,
                                 String phoneNo, String fullName) {
        final SystemUser user  = new SystemUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhoneNo(phoneNo);
        user.setPassword(hash(password));
        user.setFullName(fullName);
        user.setDeleted("NO");
        try {
            systemUserRepository.persistAndFlush(user);
            return user;
        }catch (DuplicateMappingException | ConstraintViolationException e){
            //logger.error("Unable to persist", e);
            throw new DuplicateMappingException(user);
        }
    }

    @Override
    public SystemUser createDefaultUser(String username, String email, String password,
                                        String phoneNo, String fullName) {
        Optional<UserRole> adminRole = userRoleRepository.findByName("admin");
        UserRole admin;
        if (adminRole.isEmpty()) {
            adminRole = addUserRole("admin");
        }
        admin = adminRole.orElseThrow(ResourceNotFoundException::new);
        final List<SystemUser> userList = admin.getUserList();
        if (userList != null && !userList.isEmpty() &&
            userList.stream().anyMatch(u -> "NO".equalsIgnoreCase(u.getDeleted()))){
            throw new DuplicateResourceExecption();
        }
        final SystemUser user = createUser(username, email, password, phoneNo, fullName);
        return addUserToGroup(user, admin);
    }


    @Override
    public Optional<SystemUser> findUser(String usernameOrEmail, String password) {
        return systemUserRepository.find(
                "(username = ?1 OR email = ?1 ) AND password = ?2 AND Deleted = ?3", usernameOrEmail,
                hash(password), "NO")
                .firstResultOptional();
    }

    @Override
    public Optional<SystemUser> findUser(String username) {
        return systemUserRepository.find("username = ?1 AND Deleted = ?2", username, "NO")
                .firstResultOptional();
    }

    @Override
    public String hash(String originalString) {
        return originalString;
    }

    @Override
    public Optional<SystemUser> findUser(long userId) {
        return systemUserRepository.find("id = ?1 AND Deleted = ?2", userId, "NO").firstResultOptional();
    }

    @Override
    @Transactional
    public SystemUser updateUserPassword(SystemUser systemUser) {
        final SystemUser user = systemUserRepository.getEntityManager().merge(systemUser);
        systemUserRepository.persistAndFlush(user);
        return user;
    }

    @Override
    @Transactional
    public Optional<SystemUser> delete(long userId) {
        final Optional<SystemUser> user = findUser(userId);
        if (user.isPresent()) {
            final SystemUser user1 = user.get();
            user1.setDeleted("YES");
            systemUserRepository.persistAndFlush(user1);
        }
        return user;
    }

    @Override
    public void updateUserPassword(long userId, String currentPassword, String newPassword) {

        final Optional<SystemUser> userSec = findUser(userId);
        final SystemUser user = userSec.get();
        if (user.getPassword().equals(hash(currentPassword))){
            user.setPassword(hash(newPassword));
            systemUserRepository.persistAndFlush(user);
        }
    }

    @Override
    public Optional<UserRole> findRole(String userRole) {
        return userRoleRepository.findByName(userRole);
    }

    @Transactional
    public Optional<UserRole> addUserRole(String group){
        final Optional<UserRole> name = userRoleRepository.findByName(group);
        if (name.isPresent()){
            return name;
        }
        final UserRole userRole = new UserRole();
        userRole.setRoleName(group);
        userRoleRepository.persist(userRole);
        return Optional.of(userRole);
    }

    @Transactional
    public void removeUserRole(String group){
        final Optional<UserRole> userRole = userRoleRepository.findByName(group);
        userRole.ifPresent(role -> userRoleRepository.delete(role));
    }

    @Transactional
    public SystemUser addUserToGroup(SystemUser systemUser, UserRole group) {
        final SystemUser mergedUser = systemUserRepository.getEntityManager().merge(systemUser);
        final  UserRole mergedGroup = userRoleRepository.getEntityManager().merge(group);
        if (mergedUser.getUserRoles() != null){
            mergedUser.getUserRoles().add(mergedGroup);
        }
        else{
            final Set<UserRole> roles = new HashSet<>();
            roles.add(mergedGroup);
            mergedUser.setUserRoles(roles);
        }
        systemUserRepository.persistAndFlush(mergedUser);
        return mergedUser;
    }

//    @Override
//    public void removeUserFromGroup(SystemUser systemUser, UserRole group) {
//
//        final UserRole mergeGroup = userRoleRepository.getEntityManager().merge(group);
//        if (mergeGroup.getUserList().removeIf(u -> Objects.equals(systemUser.getId(), u.getId())));
//        userRoleRepository.persistAndFlush(mergeGroup);
//
//    }


}