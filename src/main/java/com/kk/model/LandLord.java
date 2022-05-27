package com.kk.model;

import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "landlords")
public class LandLord {

    @Id
    @Column(name = "LandlordId")
    //@GenericField(name = "landlord_id", searchable = Searchable.YES, sortable = Sortable.YES)
    private Integer landlordId;

    @Column(name = "Name")
    //@FullTextField(analyzer = "english")
    //@KeywordField(name = "name_search", sortable = Sortable.YES, searchable = Searchable.YES)
    private String landlordName;

    @Column(name = "PhoneNo", length = 100)
    private String phoneNo;

    @Column(name = "Email", length = 100)
    //@KeywordField(searchable = Searchable.YES)
    private String email;

    @Column(name = "PlotName", length = 100)
    //@KeywordField(searchable = Searchable.YES)
    private String plotName;

    @OneToMany(targetEntity = Plots.class, cascade = CascadeType.ALL, mappedBy = "landLord")
    private List<Plots> plots;


    public Integer getLandlordId() {
        return landlordId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }

    public List<Plots> getPlots() {
        return plots;
    }

    public void setPlots(List<Plots> plots) {
        this.plots = plots;
    }
}
