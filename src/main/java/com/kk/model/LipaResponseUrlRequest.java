package com.kk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LipaResponseUrlRequest {

    @JsonProperty("ConversationId")
    private String conversationId;

    @JsonProperty("ResponseDescription")
    private String responseDescription;

    @JsonProperty("OriginatorConversationId")
    private String originatorConversationId;
}
