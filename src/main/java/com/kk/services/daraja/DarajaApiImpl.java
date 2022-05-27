//package com.kk.services.daraja;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.kk.config.MpesaConfiguration;
//import com.kk.model.AccessTokenResponse;
//import com.kk.model.LipaRegisterUrlRequest;
//import com.kk.utils.HelperUtility;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.RequestBody;
//import com.squareup.okhttp.Response;
//
//import java.io.IOException;
//import java.util.Objects;
//
//import static com.kk.utils.Constants.*;
//
//public class DarajaApiImpl implements DarajaApi{
//
//    private final MpesaConfiguration mpesaConfiguration;
//    private final OkHttpClient okHttpClient;
//    private final ObjectMapper objectMapper;
//
//    public DarajaApiImpl(MpesaConfiguration mpesaConfiguration, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
//        this.mpesaConfiguration = mpesaConfiguration;
//        this.okHttpClient = okHttpClient;
//        this.objectMapper = objectMapper;
//    }
//
//    @Override
//    public AccessTokenResponse getAccessToken() {
//        //get base64 rep of consumerkey and consumersecret
//        String encodeCredentials = HelperUtility.toBase64String(String.format("%s:%s", mpesaConfiguration.getConsumerKey(),
//                mpesaConfiguration.getConsumerSecret()));
//
//        Request request = new Request.Builder()
//                .url(String.format("%s?grant_type=%s", mpesaConfiguration.getOathEndpoint(), mpesaConfiguration.getGrantType()))
//                .get()
//                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BASIC_AUTH_STRING, encodeCredentials))
//                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
//                .build();
//
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//            assert response.body() != null;
//
//            //jackson to decode response body
//            return objectMapper.readValue(response.body().string(), AccessTokenResponse.class);
//        }
//        catch (IOException e){
//            log.error(String.format("could not get access token -> %s", e.getLocalizedMessage()));
//             return null;
//        }
//    }
//
//    @Override
//    public LipaRegisterUrlRequest registerUrl() {
//        AccessTokenResponse accessTokenResponse = getAccessToken();
//
//        LipaRegisterUrlRequest lipaRegisterUrlRequest = new LipaRegisterUrlRequest();
//        lipaRegisterUrlRequest.setConfirmationURL(mpesaConfiguration.getConfirmationUrl());
//        lipaRegisterUrlRequest.setResponseType(mpesaConfiguration.getResponseType());
//        lipaRegisterUrlRequest.setShortCode(mpesaConfiguration.getShortCode());
//        lipaRegisterUrlRequest.setValidationURL(mpesaConfiguration.getValidationUrl());
//
//        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE , Objects.requireNonNull(HelperUtility.toJson(lipaRegisterUrlRequest)));
//
//        Request request = new Request.Builder()
//                .url(mpesaConfiguration.getRegisterUrlEndpoint())
//                .post(body)
//                .addHeader("Authorization", String.format("Bearer" + accessTokenResponse.getAccessToken()))
//                .build();
//
//        try {
//            Response response = okHttpClient.newCall(request).execute();
//
//            return objectMapper.readValue(response.body().string(), LipaRegisterUrlRequest.class);
//        } catch (IOException e) {
//            return null;
//        }
//
//    }
//}
