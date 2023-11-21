package com.kk.services.tenant;

import com.kk.entities.Room;
import com.kk.exceptions.ResourceNotFoundException;
import com.kk.models.response.TenantResponse;
import com.kk.repository.TenantRepository;
import com.kk.services.room.RoomServiceImpl;
import com.kk.entities.Tenant;
import com.kk.models.request.CreateTenantRequest;
import com.kk.models.request.UpdateTenant;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class TenantServiceImpl implements TenantService{

   // private static final Logger logger = Logger.getLogger(TenantServiceImpl.class);
    @Inject
    TenantRepository tenantRepository;

    @Inject
    RoomServiceImpl roomServiceImpl;


    public TenantResponse convertToTenantResponseModel(Tenant tenant) {
        TenantResponse responseModel = new TenantResponse();
        responseModel.setId(tenant.getId());
        responseModel.setTenantId(tenant.getTenantId());
        responseModel.setTenantName(tenant.getTenantName());
        responseModel.setRegDate(tenant.getRegDate());
        responseModel.setGender(tenant.getGender());
        responseModel.setPhoneNo(tenant.getPhoneNo());
        responseModel.setEmail(tenant.getEmail());

        // Assuming Room has an id field
        if (Objects.nonNull(tenant.getBookedRoom())) {
            responseModel.setRoomId(tenant.getBookedRoom().getRoomId());
        }

        responseModel.setModifiedOn(tenant.getModifiedOn());
        responseModel.setUploadedOn(tenant.getUploadedOn());

        return responseModel;
    }
    @Override
    @Transactional
    public TenantResponse createTenant(CreateTenantRequest createTenantRequest) {
        Tenant tenant = new Tenant();
        tenant.setTenantId(createTenantRequest.getTenantId());
        tenant.setTenantName(createTenantRequest.getTenantName());
        tenant.setRegDate(createTenantRequest.getRegDate());
        tenant.setGender(createTenantRequest.getGender());
        tenant.setPhoneNo(createTenantRequest.getPhoneNo());
        tenant.setPlotName(createTenantRequest.getPlotName());
        tenant.setFloorNo(createTenantRequest.getFloorNo());
        tenant.setEmail(createTenantRequest.getEmail());
        //tenant.setPlot(createTenantRequest.);

        // Find an empty room in the plot and assign it to the tenant
        Room emptyRoom = roomServiceImpl.findEmptyRoomInPlot(tenant.getPlot());
        tenant.setBookedRoom(emptyRoom);

        tenantRepository.persist(tenant);

        return convertToTenantResponseModel(tenant);
    }

    @Override
    @Transactional
    public TenantResponse updateTenant(String tenantId, UpdateTenant updateTenant) {
        Tenant existingTenant = tenantRepository.findById(Long.valueOf(tenantId));
        if (existingTenant != null) {
            // Update fields based on the update request
            existingTenant.setTenantName(updateTenant.getTenantName());
            existingTenant.setRegDate(updateTenant.getRegDate());
            existingTenant.setGender(updateTenant.getGender());
            existingTenant.setPhoneNo(updateTenant.getPhoneNo());
            existingTenant.setEmail(updateTenant.getEmail());

            // Update the tenant's room if needed
            if (!Objects.equals(existingTenant.getPlotName(), updateTenant.getPlotName())) {
                Room emptyRoom = roomServiceImpl.findEmptyRoomInPlot(existingTenant.getPlot());
                existingTenant.setBookedRoom(emptyRoom);
            }

            // Persist the changes
            tenantRepository.persist(existingTenant);

            // Convert and return the updated tenant
            return convertToTenantResponseModel(existingTenant);
        } else {
            // Handle the case where the tenant with the given ID is not found
            throw new ResourceNotFoundException("Tenant not found with ID: " + tenantId);
        }
    }

    @Override
    @Transactional
    public Optional<Tenant> delete(String tenantId) {
        Optional<Tenant> optionalTenant = tenantRepository.findByIdOptional(Long.valueOf(tenantId));
        if (optionalTenant.isPresent()) {
            Tenant tenantToDelete = optionalTenant.get();
            tenantRepository.delete(tenantToDelete);
            return Optional.of(tenantToDelete);
        } else {
            // Handle the case where the tenant with the given ID is not found
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<TenantResponse> find(String tenantId) {
        Optional<Tenant> optionalTenant = tenantRepository.findByIdOptional(Long.valueOf(tenantId));
        return optionalTenant.map(this::convertToTenantResponseModel);
    }

    @Override
    public List getAllTenant() {
        List<Tenant> tenants = tenantRepository.listAll();
        return tenants.stream()
                .map(this::convertToTenantResponseModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TenantResponse> getTenantByPlots(String plotId) {
        List<Tenant> tenantsInPlot = tenantRepository.findTenantsByPlotId(Long.valueOf(plotId));
        if (!tenantsInPlot.isEmpty()) {
            return Optional.of(convertToTenantResponseModel(tenantsInPlot.get(0)));
        } else {
            // Handle the case where no tenant is found in the specified plot
            return Optional.empty();
        }


    }
    }


//    @Override
//    public Page<Tenant> search(StringFilter stringFilter, PageRequest pageRequest) {
//        return null;
//    }
//
//    @Override
//    public Page<Tenant> fetchTenants(int page, int size) {
//        size = Pagination
//    }
//}
