package com.kk.repository;

import com.kk.entities.Plots;
import com.kk.entities.Room;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoomRepository implements PanacheRepositoryBase<Room, Long > {
}
