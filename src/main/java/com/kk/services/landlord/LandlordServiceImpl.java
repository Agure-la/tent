package com.kk.services.landlord;

import com.kk.model.LandLord;
import com.kk.repository.landlord.LandlordRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

public class LandlordServiceImpl implements LandlordService{

    @Inject
    LandlordRepository landlordRepository;

    @Override
    @Transactional
    public LandLord createLandlord(LandLord landLord) {
        landlordRepository.persist(landLord);
        return landLord;
    }

    @Override
    @Transactional
    public LandLord updateLandlord(LandLord landLord) {
        //awating implementation
        return landLord;
    }

    @Override
    public Optional<LandLord> findLandlord(int landlordId) {
        return null;
    }

    @Override
    public Optional<LandLord> deleteLandlord(int landlordId) {
        return null;
    }
}
