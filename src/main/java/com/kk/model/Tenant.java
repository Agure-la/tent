package com.kk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.RoutingBinderRef;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.engine.backend.types.Searchable;
import java.time.LocalDateTime;

@Entity
@Indexed(routingBinder = @RoutingBinderRef)
@Table(name= "plot_tenants")
public class Tenant {
    @Id
    @Column(name = "RegNo")
    @GenericField(name= "reg_no", searchable= Searchable.YES, sortable = Sortable.YES)
    private Integer registrationNo;

    @Column(name = "TenantName", nullable = false, length = 200)
    @FullTextField(analyzer = "english")
    @KeywordField(name = "tenant_name", sortable = Sortable.YES)
    private String tenantName;

    @Column(name = "RegDate")
    @GenericField
    private LocalDateTime regDate;

    @Column(name = "Gender")
    @KeywordField(name = "gender")
    private String gender;

    @Column(name = "PhoneNo", length = 100)
    @GenericField
    private String phoneNo;

    @Column(name = "PlotName", length = 50)
    @KeywordField(name = "plot_name", searchable = Searchable.YES, sortable = Sortable.YES)
    private String plotName;

    @Column(name = "FloorNo")
    private Integer floorNo;

    @Column(name = "DoorNo")
    private String doorNo;

    @Column(name = "Password", length = 200)
    private String password;

    @Column(name = "ModifiedOn")
    private LocalDateTime modifiedOn;

    @Column(name = "Email", length = 100)
    @KeywordField(searchable = Searchable.YES)
    private String email;

    @Column(name = "Deleted", length = 10)
    @KeywordField(searchable = Searchable.YES, sortable = Sortable.YES)
    private String deleted;

    @Column(name = "DeletedOn")
    private LocalDateTime deletedOn;

    @Column(name = "UploadedOn")
    private LocalDateTime uploadedOn;

    public Integer getRegistrationNo() {
        return registrationNo;
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

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(LocalDateTime deletedOn) {
        this.deletedOn = deletedOn;
    }

    public LocalDateTime getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(LocalDateTime uploadedOn) {
        this.uploadedOn = uploadedOn;
    }
}
