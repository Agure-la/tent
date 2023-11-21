package com.kk.services.landlord;

import com.kk.entities.Plots;
import com.kk.entities.LandLord;
import com.kk.exceptions.ResourceNotFoundException;
import com.kk.models.request.CreateLandlordRequest;
import com.kk.models.request.UpdateLandlordRequest;
import com.kk.models.response.LandlordResponseModel;
import com.kk.models.response.PlotResponse;
import com.kk.repository.LandlordRepository;
import com.kk.services.plots.PlotsServiceImpl;
import com.kk.utils.IdGenerator;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LandlordServiceImpl implements LandlordService{

    @Inject
    LandlordRepository landlordRepository;

    @Inject
    PlotsServiceImpl plotsServiceImpl;


    public LandLord checkLandlord(String landlordId){
        final Optional<LandLord> landLord = landlordRepository.findByLandlordId(landlordId);
        if (landLord.isEmpty()){
            //throw error
        }

        return landLord.get();
    }


    @Override
    @Transactional
    public LandlordResponseModel createLandlord(CreateLandlordRequest createLandlordRequest) {
        LandLord landLord = new LandLord();
        landLord.setLandlordId(IdGenerator.generateLandlordIt());
        landLord.setLandlordName(createLandlordRequest.getLandlordName());
        landLord.setPhoneNo(createLandlordRequest.getPhoneNo());
        landLord.setEmail(createLandlordRequest.getEmail());
        landLord.setPlotName(createLandlordRequest.getPlotName());

        landlordRepository.persist(landLord);

        LandlordResponseModel landlordResponseModel =convertToLandResponseModel(landLord);

        return landlordResponseModel;
    }

    public LandlordResponseModel convertToLandResponseModel(LandLord landLord){
        LandlordResponseModel responseModel = new LandlordResponseModel();
        responseModel.setId(landLord.getId());
        responseModel.setLandlordId(landLord.getLandlordId());
        responseModel.setLandlordName(landLord.getLandlordName());
        responseModel.setPhoneNo(landLord.getPhoneNo());
        responseModel.setEmail(landLord.getEmail());
        responseModel.setPlotName(landLord.getPlotName());

        //  method convertToPlotResponseModel
       // List<PlotResponse> plotResponses = plotsServiceImpl.convertToPlotResponseModel(landLord.getPlots());
       // responseModel.setPlots(plotResponses);

        return responseModel;
    }



    @Override
    @Transactional
    public LandlordResponseModel updateLandlord(String landLordId, UpdateLandlordRequest updateLandlordRequest) {
         LandLord landLord = landlordRepository.findById(Long.valueOf(landLordId));

         if (updateLandlordRequest != null){
             landLord = new LandLord();

             if(updateLandlordRequest.getLandlordName() != null){
                 landLord.setLandlordName(updateLandlordRequest.getLandlordName());
         }
         if (updateLandlordRequest.getPhoneNo() != null){
             landLord.setPhoneNo(updateLandlordRequest.getPhoneNo());
         }
         if (updateLandlordRequest.getEmail() != null){
             landLord.setEmail(updateLandlordRequest.getEmail());
         }
         if (updateLandlordRequest.getPlotName() != null){
             landLord.setPlotName(updateLandlordRequest.getPlotName());
         }

         landlordRepository.persist(landLord);
       }

         LandlordResponseModel responseModel = convertToLandResponseModel(landLord);

        return responseModel;
    }

    @Override
    @Transactional
    public Optional<LandlordResponseModel> findLandlord(Long landlordId) {
        Optional<LandLord> optionalLandLord = landlordRepository.findByIdOptional(landlordId);
        return optionalLandLord.map(this::convertToLandResponseModel);
    }

    @Override
    @Transactional
    public Optional<LandLord> deleteLandlord(Long landlordId) {
        Optional<LandLord> optionalLandLord = landlordRepository.findByIdOptional(landlordId);
        optionalLandLord.ifPresent(landlordRepository::delete);
        return optionalLandLord;
    }

    @Override
    @Transactional
    public List allLandlords() {
        List<LandLord> landlords = landlordRepository.listAll();
        return landlords.stream()
                .map(this::convertToLandResponseModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LandlordResponseModel getLandlordById(Long landlordId) {
        LandLord landLord = landlordRepository.findById(landlordId);
        if (landLord != null) {
            return convertToLandResponseModel(landLord);
        } else {
            // You can throw an exception, return null, or handle it based on your requirements
            throw new ResourceNotFoundException("Landlord not found with ID: " + landlordId);
        }
    }

}
