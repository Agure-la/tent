package com.kk.entities;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
//@Indexed(routingBinder = @RoutingBinderRef)
@Table(name= "plot_tenants")
public class Tenant {
    @Id
    @Column(name = "RegNo")
    //@GenericField(name= "reg_no", searchable= Searchable.YES, sortable = Sortable.YES)
    private Long id;

    @Column(name = "tenantId")
    private String tenantId;

    @Column(name = "TenantName", nullable = false, length = 200)
    //@FullTextField(analyzer = "english")
    //@KeywordField(name = "tenant_name", sortable = Sortable.YES)
    private String tenantName;

    @Column(name = "RegDate")
    //@GenericField
    private LocalDateTime regDate;

    @Column(name = "Gender")
    //@KeywordField(name = "gender")
    private String gender;

    @Column(name = "PhoneNo", length = 100)
    //@GenericField
    private String phoneNo;

    @Column(name = "PlotName", length = 50)
    //@KeywordField(name = "plot_name", searchable = Searchable.YES, sortable = Sortable.YES)
    private String plotName;

    @Column(name = "FloorNo")
    private Integer floorNo;

    @ManyToOne
    @JoinColumn(name = "plot_id") // Assuming the column in the Tenant table that references the Plots table is named plot_id
    private Plots plot;

    @Column(name = "Room")
    private Room bookedRoom;

    @Column(name = "ModifiedOn")
    private LocalDateTime modifiedOn;

    @Column(name = "Email", length = 100)
    //@KeywordField(searchable = Searchable.YES)
    private String email;


    @Column(name = "UploadedOn")
    private LocalDateTime uploadedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Plots getPlot() {
        return plot;
    }

    public void setPlot(Plots plot) {
        this.plot = plot;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }


    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDateTime getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(LocalDateTime uploadedOn) {
        this.uploadedOn = uploadedOn;
    }
}
