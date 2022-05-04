package com.kk.services.tenant;

import com.kk.model.Tenant;
import java.util.Optional;

public interface TenantService {

    Tenant createTenant(Tenant tenant);

    Tenant updateTenant(Tenant tenant);

    Optional<Tenant> delete(int registrationNo);

    Optional<Tenant> find(int registrationNo);

//    Page<Tenant> search(StringFilter stringFilter, PageRequest pageRequest);
//
//    Page<Tenant> fetchTenants(int page, int size);
}
