package com.kk.services.landlord;

import com.kk.model.LandLord;
import com.kk.entities.LandLord;
import com.kk.models.request.CreateLandlordRequest;
import com.kk.models.request.UpdateLandlordRequest;
import com.kk.repository.LandlordRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class LandlordServiceImpl implements LandlordService{

    @Inject
    LandlordRepository landlordRepository;


    public LandLord checkLandlord(String landlordId){
        final Optional<LandLord> landLord = landlordRepository.findByLandlordId(landlordId);
        if (landLord.isEmpty()){
            //throw error
        }

        return landLord.get();
    }


    @Override
    @Transactional
    public LandLord createLandlord(CreateLandlordRequest createLandlordRequest) {
        return null;
    }

    @Override
    @Transactional
    public LandLord updateLandlord(UpdateLandlordRequest updateLandlordRequest) {
        return null;
    }

    @Override
    @Transactional
    public Optional<LandLord> findLandlord(Long landlordId) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<LandLord> deleteLandlord(Long landlordId) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public List allLandlords() {
        return null;
    }
}
