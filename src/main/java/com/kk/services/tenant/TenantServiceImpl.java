package com.kk.services.tenant;

import com.kk.model.Tenant;
import com.kk.repository.TenantRepository;
import io.quarkus.runtime.StartupEvent;
import org.hibernate.search.mapper.orm.session.SearchSession;
import javax.enterprise.event.Observes;
import com.kk.entities.Tenant;
import com.kk.models.request.CreateTenantRequest;
import com.kk.models.request.UpdateTenant;
import com.kk.repository.TenantRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Optional;

@Singleton
public class TenantServiceImpl implements TenantService{

   // private static final Logger logger = Logger.getLogger(TenantServiceImpl.class);
    @Inject
    TenantRepository tenantRepository;



    @Override
    @Transactional
    public Tenant createTenant(Tenant tenant) {
        tenant.setDeleted("NO");
    public Tenant createTenant(CreateTenantRequest createTenantRequest) {
        tenantRepository.persist(tenant);
        return tenant;
    }

    @Override
    @Transactional
    public Tenant updateTenant(Tenant tenant) {
    public Tenant updateTenant(UpdateTenant updateTenant) {
        final Tenant updatetent = tenantRepository.getEntityManager().merge(tenant);
        tenantRepository.persist(updatetent);
        return updatetent;
    }

    @Override
    @Transactional
    public Optional<Tenant> delete(int registrationNo) {
      final Optional<Tenant> optional = tenantRepository.find("RegNo = ?1 and Deleted != ?2",
              registrationNo, "YES").firstResultOptional();
      if (optional.isPresent()){
          tenantRepository.update("Deleted = ?1 WHERE RegNo = ?2", "YES", registrationNo);
      }
    public Optional<Tenant> delete(Long tenantId) {
      final Optional<Tenant> optional = tenantRepository.find("tenantId = ?1",
              tenantId).firstResultOptional();
      if (optional.isPresent()){
          tenantRepository.delete(String.valueOf(optional));
      }
//      if (optional.isPresent()){
//          tenantRepository.update("Deleted = ?1 WHERE RegNo = ?2", "YES", registrationNo);
//      }
      return optional;
    }

    @Override
    public Optional<Tenant> find(int registrationNo) {
        return tenantRepository.find("RegNo = ?1 and Deleted != ?2", registrationNo, "YES").firstResultOptional();

    }

    @Override
    public Tenant getAllTenant(Tenant tenant) {
         tenantRepository.findAll();
         return tenant;
    }

    @Override
    public Optional<Tenant> getTenantByPlots(String tenantName, String plotName) {

        return tenantRepository.find("TenantName = ?1 AND PlotName = ?2", tenantName, plotName).firstResultOptional();
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
}
