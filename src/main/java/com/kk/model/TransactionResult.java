package com.kk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionResult {

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("BillRefNumber")
    private String BillRefNumber;

    @JsonProperty("Mission")
    private String mission;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("MiddleName")
    private String middleName;

    @JsonProperty("BusinessShortCode")
    private String businessShortCode;

    @JsonProperty("OrganizationAccountBalance")
    private String organizationAccountBalance;

    @JsonProperty("TransAmount")
    private String transAmount;

    @JsonProperty("ThirdPartyTransID")
    private String thirdPartyTransID;

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("TransID")
    private String tTransID;
}
