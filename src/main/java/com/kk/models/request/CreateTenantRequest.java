package com.kk.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CreateTenantRequest {

    @JsonProperty("tenantId")
    private String tenantId;
    @JsonProperty("tenantName")
    private String tenantName;

    @JsonProperty("regDate")
    private LocalDateTime regDate;
    @JsonProperty("gender")
    private String gender;

    @JsonProperty("phoneNo")
    private String phoneNo;

    @JsonProperty("plotName")
    private String plotName;

    @JsonProperty("floorNo")
    private Integer floorNo;

    @JsonProperty("email")
    private String email;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
