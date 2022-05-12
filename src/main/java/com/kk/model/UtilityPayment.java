package com.kk.model;


import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

@Data
public class UtilityPayment {

    @Column(name = "ProviderId")
    private Long providerId;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "ReferenceNumber")
    private String referenceNumber;

    @Column(name = "Account")
    private String account;

    @Column(name = "Status")
    private TransactionStatus status;
}
