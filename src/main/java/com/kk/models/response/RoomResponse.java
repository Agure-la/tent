package com.kk.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("roomId")
    private String roomId;

    @JsonProperty("roomNumber")
    private String roomNumber;

    @JsonProperty("isBooked")
    private boolean isBooked;

    @JsonProperty("plot")
    private Long plotId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }
}
