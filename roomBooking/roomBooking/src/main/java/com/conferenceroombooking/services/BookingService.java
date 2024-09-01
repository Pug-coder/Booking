package main.java.com.conferenceroombooking.services;

import main.java.com.conferenceroombooking.models.Booking;
import main.java.com.conferenceroombooking.models.Room;

import java.util.ArrayList;

public class BookingService {
    private ArrayList<Room> rooms;

    public BookingService() {
        this.rooms = new ArrayList<>();
    }

    public void viewRooms() {
        for (Room room : rooms) {
            System.out.println(room.getRoomNumber());
        }
    }

    public void viewRoomBookings(int roomNumber) {
        Room foundedRoomNumber = null;

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                foundedRoomNumber = room;
                break;
            }
        }

        if (foundedRoomNumber == null) {
            System.out.println("Room not found");
            return;
        }

        for (Booking booking : foundedRoomNumber.getBookings()) {
            System.out.printf("%s - %s%n",
                    booking.getStartTime(),
                    booking.getEndTime());
        }
    }

}
