package com.kk.services.landlord;

import com.kk.model.LandLord;
import com.kk.entities.LandLord;
import com.kk.models.request.CreateLandlordRequest;
import com.kk.models.request.UpdateLandlordRequest;
import com.kk.repository.LandlordRepository;

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
    public LandLord createLandlord(CreateLandlordRequest createLandlordRequest) {
        landlordRepository.persist(createLandlordRequest);
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
    public LandLord updateLandlord(UpdateLandlordRequest updateLandlordRequest) {
        //awating implementation
        return updateLandlordRequest;
    }

    @Override
    public Optional<LandLord> findLandlord(Long landlordId) {
        return null;
    }

    @Override
    public Optional<LandLord> deleteLandlord(int landlordId) {
    public Optional<LandLord> deleteLandlord(Long landlordId) {
        return null;
    }
}
