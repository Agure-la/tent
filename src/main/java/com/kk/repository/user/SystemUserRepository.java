package com.kk.repository.user;

import com.kk.model.SystemUser;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SystemUserRepository implements PanacheRepositoryBase<SystemUser, Long> {
}
