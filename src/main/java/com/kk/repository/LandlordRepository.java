package com.kk.repository;

import com.kk.entities.LandLord;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class LandlordRepository implements PanacheRepositoryBase<LandLord, Long> {

    public Optional<LandLord> findByLandlordId(String landLordId) {
        return find("landLordId", landLordId).firstResultOptional();
    }
}
