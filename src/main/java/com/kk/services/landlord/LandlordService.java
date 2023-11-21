package com.kk.services.landlord;

import com.kk.entities.LandLord;
import com.kk.models.request.CreateLandlordRequest;
import com.kk.models.request.UpdateLandlordRequest;
import com.kk.models.response.LandlordResponseModel;

import java.util.List;
import java.util.Optional;

public interface LandlordService {

    LandlordResponseModel createLandlord(CreateLandlordRequest createLandlordRequest);

    LandlordResponseModel updateLandlord(String landLordId,UpdateLandlordRequest updateLandlordRequest);

    Optional<LandlordResponseModel> findLandlord(Long landlordId);

    Optional<LandLord> deleteLandlord(Long landlordId);

    List allLandlords();

    public LandlordResponseModel getLandlordById(Long landlordId);
}
