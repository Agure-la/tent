package com.kk.services.user;

import com.kk.model.SystemUser;
import com.kk.model.UserRole;

import com.kk.resource.requests.CreateUserRequestModel;
import java.util.Optional;

public interface UserService {

    SystemUser createUser(CreateUserRequestModel requestModel) throws Exception;

    String hash(String hsh);

    Optional<SystemUser> findUser(long userId);

    SystemUser updateUserPassword(SystemUser systemUser);

    Optional<SystemUser> delete(long userId);

    void updateUserPassword(long userId, String currentPassword, String newPassword);

    Optional<UserRole> findRole(String userRole);

    SystemUser addUserToGroup(SystemUser systemUser, UserRole userRole);

    //void removeUserFromGroup(SystemUser systemUser, UserRole userRole);

    SystemUser createDefaultUser(String username, String email, String password, String phoneNo, String fullName) throws Exception;

    Optional<SystemUser> findUser(String usernameOrEmail, String password);

    Optional<SystemUser> findUser(String username);
}
