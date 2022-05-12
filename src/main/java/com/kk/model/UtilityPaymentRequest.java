package com.kk.model;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class UtilityPaymentRequest {

    @Column(name = "ProviderId")
    @NotNull
    private Long providerId;

    @Column(name = "Amount")
    @NotNull
    private BigDecimal amount;

    @Column(name = "ReferenceNumber")
    @NotNull
    private BigDecimal referenceNumber;

    @Column(name = "Account")
    @NotNull
    private BigDecimal account;
}
