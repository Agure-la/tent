package com.kk.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Locale;

@Entity
@Table(name = "plots")
public class Plots {

    @Id
    @Column(name = "PlotNo")
    //@GenericField(name = "plot_no", searchable = Searchable.YES, sortable = Sortable.YES)
    private Integer plotNo;

    @Column(name = "PlotName")
    //@FullTextField(analyzer = "english")
    //@KeywordField(name = "plot_name", searchable = Searchable.YES, sortable = Sortable.YES)
    private String plotName;

    @Column(name = "NumberOfFloors")
    private Integer numberOfFloors;

    @Column(name = "Description")
    private String description;

    @Column(name = "NumberOfRooms")
    private String numberOfRooms;

    @Column(name = "location")
    @NotNull
    //@KeywordField(name = "location", searchable = Searchable.YES, sortable = Sortable.YES)
    private Locale location;

    @Column(name = "RoomStatus")
    //@KeywordField(name = "room_status", searchable = Searchable.YES, sortable = Sortable.YES)
    @NotNull
    private boolean roomStatus;

    @ManyToOne
    private LandLord landLord;

    public Integer getPlotNo() {
        return plotNo;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Locale getLocation() {
        return location;
    }

    public void setLocation(Locale location) {
        this.location = location;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }
}
