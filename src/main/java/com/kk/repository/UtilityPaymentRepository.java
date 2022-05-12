package com.kk.repository;

import com.kk.model.Payment;
import com.kk.model.UtilityPayment;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public class UtilityPaymentRepository implements PanacheRepositoryBase<Payment, UtilityPayment> {
}
