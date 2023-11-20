package com.kk.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "plots")
public class Plots {

    @Id
    @Column(name = "Id")
    //@GenericField(name = "plot_no", searchable = Searchable.YES, sortable = Sortable.YES)
    private Long Id;

    @Column(name = "PlotId")
    private String plotId;

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
    private String  location;

    @ManyToOne
    private LandLord landLord;

    private List<Room> rooms;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPlotId() {
        return plotId;
    }

    public void setPlotId(String plotId) {
        this.plotId = plotId;
    }

    public LandLord getLandLord() {
        return landLord;
    }

    public void setLandLord(LandLord landLord) {
        this.landLord = landLord;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}
