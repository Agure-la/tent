//package com.kk.model;
//
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;
//
//import java.io.IOException;
//
//public class LipaAuth {
//
//    OkHttpClient client = new OkHttpClient().newBuilder().build();
//    Request request = new Request.Builder()
//            .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
//            .method("GET", null)
//            .addHeader("Authorization", "Basic cFJZcjZ6anEwaThMMXp6d1FETUxwWkIzeVBDa2hNc2M6UmYyMkJmWm9nMHFRR2xWOQ==")
//            .build();
//    Response response = client.newCall(request).execute();
//
//    public LipaAuth() throws IOException {
//    }
//}
