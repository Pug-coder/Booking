package roomBooking.roomBooking.src.main.java.com.conferenceroombooking.models;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Room {
    private int roomNumber;
    private ArrayList<Booking> bookings;

    public Room(int roomNumber) {
        setRoomNumber(roomNumber);
        this.bookings = new ArrayList<>();
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ArrayList<Booking> getBookings() {
        return this.bookings;
    }

    public void addBooking(Booking newBooking) {
        if (checkRoomIsAvailable(newBooking)) {
            bookings.add(newBooking);
        } else {
            System.out.println("Booking cannot be added. Please choose another time.");
        }

    }

    // TODO: check if exists
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public void viewBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking.getStartTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))
                    + "-"
                    + booking.getEndTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        }
    }

    public boolean checkRoomIsAvailable(Booking checkingBooking) {
        for (Booking booking : bookings) {
            if (checkingBooking.conflictsWith(booking)) {
                System.out.printf("Conflict with another booking%n %s - %s",
                        booking.getStartTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                        booking.getEndTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
                return false;
            }
        }
        return true;
    }
}
