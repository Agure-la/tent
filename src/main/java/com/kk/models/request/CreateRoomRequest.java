package com.kk.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRoomRequest {

    @JsonProperty("roomId")
    private String roomId;

    @JsonProperty("roomNumber")
    private String roomNumber;

    @JsonProperty("PlotId")
    private Long plotId;

    @JsonProperty("isBooked")
    private boolean isBooked;

    public CreateRoomRequest(String roomId, String roomNumber, Long plotId, boolean isBooked) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.plotId = plotId;
        this.isBooked = false;  // Set isBooked to false by default
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

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
