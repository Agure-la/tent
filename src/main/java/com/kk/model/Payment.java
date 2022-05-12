package com.kk.model;

import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "utility_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "ProviderId")
    private Long providerId;

    @Column(name = "Amount")
    @NotNull
    private BigDecimal amount;

    @Column(name = "ReferenceNumber")
    @NotNull
    @KeywordField(searchable = Searchable.YES)
    private String referenceNumber;

    @Column(name = "Account")
    @NotNull
    @KeywordField(searchable = Searchable.YES, sortable = Sortable.YES)
    private String account;

    @Column(name = "TransactionId")
    @NotNull
    @KeywordField(searchable = Searchable.YES, sortable = Sortable.YES)
    private String transactionId;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    public Long getId() {
        return id;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
