package com.kk.repository;

import com.kk.model.Plots;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlotRepository implements PanacheRepositoryBase<Plots, Integer > {
}
