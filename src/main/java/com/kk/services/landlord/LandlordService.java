package com.kk.services.landlord;

import com.kk.model.LandLord;
import org.openjdk.jmh.util.Optional;

public interface LandlordService {

    LandLord createLandlord(LandLord landLord);

    LandLord updateLandlord(LandLord landLord);

    Optional<LandLord> findLandlord(int landlordId);

    Optional<LandLord> deleteLandlord(int landlordId);
}
