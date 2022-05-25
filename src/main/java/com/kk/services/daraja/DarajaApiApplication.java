package com.kk.services.daraja;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import io.micronaut.context.annotation.Bean;

public class DarajaApiApplication {

    @Bean
    public OkHttpClient getOkHttpClient(){
        return new OkHttpClient();
    }

    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
