package com.kk.services.login;

import javax.inject.Named;
import javax.inject.Singleton;

@Named("cross-service")
@Singleton
public class CrossServiceImpl implements LoginService{
    @Override
    public Token login(String username, String password) {
        return null;
    }

    @Override
    public Token loginAsGuest(String username) {
        return null;
    }

    @Override
    public Token refresh(String refreshToken) {
        return null;
    }

    @Override
    public void logout(String refreshToken) {

    }
}
