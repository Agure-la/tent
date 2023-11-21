package com.kk.repository;

import com.kk.entities.Plots;
import com.kk.entities.Room;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RoomRepository implements PanacheRepositoryBase<Room, Long > {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Room> findByPlot(Plots plot){
        return entityManager.createQuery(
                        "SELECT r FROM Room r WHERE r.plot = :plot", Room.class)
                .setParameter("plot", plot)
                .getResultList();
    }
}
