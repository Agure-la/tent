package com.kk.repository;

import com.kk.model.Tenant;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TenantRepository implements PanacheRepositoryBase<Tenant, Long> {
}
