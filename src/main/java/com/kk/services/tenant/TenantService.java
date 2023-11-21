package com.kk.services.tenant;
import com.kk.entities.Tenant;
import com.kk.models.request.CreateTenantRequest;
import com.kk.models.request.UpdateTenant;
import com.kk.models.response.TenantResponse;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TenantService {

    TenantResponse createTenant(CreateTenantRequest createTenantRequest);

    @Transactional
    TenantResponse updateTenant(String tenantId, UpdateTenant updateTenant);

    Optional<Tenant> delete(String tenantId);

    Optional<TenantResponse> find(String tenantId);

//    Page<Tenant> search(StringFilter stringFilter, PageRequest pageRequest);
//
//    Page<Tenant> fetchTenants(int page, int size);
List getAllTenant();

    Optional<TenantResponse> getTenantByPlots(String plotId);
}
