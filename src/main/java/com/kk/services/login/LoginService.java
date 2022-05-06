package com.kk.services.login;

public interface LoginService {

    Token login(String username, String password);

    Token loginAsGuest(String username);

    Token refresh(String refreshToken);

    void logout(String refreshToken);
}
