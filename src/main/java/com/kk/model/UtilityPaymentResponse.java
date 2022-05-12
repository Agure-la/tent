package com.kk.model;

import lombok.Data;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class UtilityPaymentResponse {

    @Column(name = "Message")
    @NotNull
    private String message;

    @Column(name = "TransactionId")
    @NotNull
    @KeywordField(searchable = Searchable.YES, sortable = Sortable.YES)
    private String transactionId;
}
