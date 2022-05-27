package com.kk.resource.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequestModel {

  @JsonProperty("username")
  String username;

  @JsonProperty("email")
  String email;

  @JsonProperty("password")
  String password;

  @JsonProperty("phoneNo")
  String phoneNo;

  @JsonProperty("fullName")
  String fullName;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}
