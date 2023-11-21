package com.kk.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class TenantResponse {

    @JsonProperty("id")
    private Long id;

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

    @JsonProperty("plot")
    private PlotResponse plot;

    @JsonProperty("bookedRoom")
    private RoomResponse bookedRoom;

    @JsonProperty("modifiedOn")
    private LocalDateTime modifiedOn;
    @JsonProperty("email")
    private String email;

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

    public PlotResponse getPlot() {
        return plot;
    }

    public void setPlot(PlotResponse plot) {
        this.plot = plot;
    }

    public RoomResponse getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(RoomResponse bookedRoom) {
        this.bookedRoom = bookedRoom;
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

    public void setRoomId(String roomId) {
    }

    public void setUploadedOn(LocalDateTime uploadedOn) {
    }
}
