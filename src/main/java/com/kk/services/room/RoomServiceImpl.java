package com.kk.services.room;

import com.kk.entities.Plots;
import com.kk.entities.Room;
import com.kk.repository.RoomRepository;

import javax.inject.Inject;
import java.util.List;

public class RoomServiceImpl {

    @Inject
    RoomRepository roomRepository;

    public Room findEmptyRoomInPlot(Plots plot) {
        // Assuming there's a method in RoomRepository to get all rooms associated with a plot
        List<Room> roomsInPlot = roomRepository.findByPlot(plot);

        // Iterate through the rooms and return the first one that is not booked
        for (Room room : roomsInPlot) {
            if (!room.isBooked()) {
                return room;
            }
        }

        // If all rooms are booked, you can handle it based on your requirements
        // For example, throw an exception or return null
        throw new RuntimeException("No empty room found in the plot: " + plot.getPlotName());
    }
}
