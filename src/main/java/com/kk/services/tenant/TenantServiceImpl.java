package com.kk.services.tenant;

import com.kk.model.Tenant;
import com.kk.repository.TenantRepository;
import io.quarkus.runtime.StartupEvent;
import org.hibernate.search.mapper.orm.session.SearchSession;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Optional;

@Singleton
public class TenantServiceImpl implements TenantService{

   // private static final Logger logger = Logger.getLogger(TenantServiceImpl.class);
    @Inject
    TenantRepository tenantRepository;
    @Inject
    SearchSession searchSession;

    @Transactional
    void onStart(@Observes StartupEvent ev) throws InterruptedException {
        if(tenantRepository.count() > 0) {
            searchSession.massIndexer()
                    .startAndWait();
        }
    }

    @Override
    @Transactional
    public Tenant createTenant(Tenant tenant) {
        tenant.setDeleted("NO");
        tenantRepository.persist(tenant);
        return tenant;
    }

    @Override
    @Transactional
    public Tenant updateTenant(Tenant tenant) {
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
    public Tenant getTenantByPlots(String tenantName, String plotName) {
        return null;
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
