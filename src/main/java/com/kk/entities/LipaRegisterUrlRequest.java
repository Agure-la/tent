package com.kk.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LipaRegisterUrlRequest {

    @JsonProperty("ShortCode")
    private String shortCode;

    @JsonProperty("ConfirmationURL")
    private String confirmationURL;

    @JsonProperty("ValidationURL")
    private String validationURL;

    @JsonProperty("ResponseType")
    private String responseType;
}
