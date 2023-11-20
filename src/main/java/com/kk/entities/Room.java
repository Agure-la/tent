package com.kk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @javax.persistence.Id
    @Column(name = "Id")
    private Long Id;

    @Column(name = "room_id")
    private String roomId;

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "status")
    private boolean isBooked;
    private Plots plot;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Plots getPlot() {
        return plot;
    }

    public void setPlot(Plots plot) {
        this.plot = plot;
    }
}
