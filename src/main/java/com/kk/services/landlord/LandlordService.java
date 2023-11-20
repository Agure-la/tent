package com.kk.services.landlord;

import com.kk.model.LandLord;

import com.kk.entities.LandLord;
import com.kk.models.request.CreateLandlordRequest;
import com.kk.models.request.UpdateLandlordRequest;

import java.util.List;
import java.util.Optional;

public interface LandlordService {

    LandLord createLandlord(LandLord landLord);

    LandLord updateLandlord(LandLord landLord);

    Optional<LandLord> findLandlord(int landlordId);

    Optional<LandLord> deleteLandlord(int landlordId);
    LandLord createLandlord(CreateLandlordRequest createLandlordRequest);

    LandLord updateLandlord(UpdateLandlordRequest updateLandlordRequest);

    Optional<LandLord> findLandlord(Long landlordId);

    Optional<LandLord> deleteLandlord(Long landlordId);

    List allLandlords();
}
