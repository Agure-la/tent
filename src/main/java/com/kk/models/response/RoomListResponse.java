package com.kk.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoomListResponse {

    @JsonProperty("rooms")
    private List<RoomResponse> rooms;

    public List<RoomResponse> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomResponse> rooms) {
        this.rooms = rooms;
    }
}
