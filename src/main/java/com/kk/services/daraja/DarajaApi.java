package com.kk.services.daraja;

import com.kk.model.AccessTokenResponse;
import com.kk.model.LipaRegisterUrlRequest;

public interface DarajaApi {

    AccessTokenResponse getAccessToken();

    LipaRegisterUrlRequest registerUrl();
}
