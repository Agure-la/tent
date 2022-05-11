package com.kk.repository;

import com.kk.model.LandLord;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LandlordRepository implements PanacheRepositoryBase<LandLord, Integer> {
}
