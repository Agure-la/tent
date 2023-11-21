package com.kk.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.kk.entities.Tenant;
import org.jboss.resteasy.annotations.Query;

import java.util.List;

@ApplicationScoped
public class TenantRepository implements PanacheRepositoryBase<Tenant, Long> {

    @Inject
    EntityManager entityManager;

    public List<Tenant> findTenantsByPlotId(Long plotId) {
        return entityManager.createQuery("SELECT t FROM Tenant t WHERE t.plot.id = :plotId", Tenant.class)
                .setParameter("plotId", plotId)
                .getResultList();
    }
}
