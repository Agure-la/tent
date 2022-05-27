package com.kk.service;

import com.kk.model.SystemUser;
import com.kk.repository.SystemUserRepository;
import com.kk.resource.requests.CreateUserRequestModel;
import com.kk.services.user.UserServiceImpl;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(value = H2DatabaseTestResource.class, parallel = true)
public class UserServiceTest {

  @Inject
  UserServiceImpl userServiceImpl;

  @Inject
  SystemUserRepository systemUserRepository;

  @Test
  @Transactional
  void testCanCreateNewUser(){

    CreateUserRequestModel createUserRequestModel = new CreateUserRequestModel();
    createUserRequestModel.setFullName("A test User");
    createUserRequestModel.setUsername("TestUsername");
    createUserRequestModel.setPhoneNo("2548888888888");
    createUserRequestModel.setEmail("test@mail.com");
    createUserRequestModel.setPassword("45423wdfwrerwe");

    try {
      final SystemUser user = userServiceImpl.createUser(createUserRequestModel);

      final SystemUser systemUser = systemUserRepository.findById(user.getId());

      Assertions.assertEquals("A test User", systemUser.getFullName());
      Assertions.assertEquals("TestUsername", systemUser.getUsername());


    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}
