package com.kk.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "landlords")
public class LandLord {

    @Id
    @Column(name = "id")
    //@GenericField(name = "landlord_id", searchable = Searchable.YES, sortable = Sortable.YES)
    private Long id;

    @Column(name = "LandlordId")
    private String landlordId;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
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


    public List<Plots> getPlots() {
        return plots;
    }

    public void setPlots(List<Plots> plots) {
        this.plots = plots;
    }
}
