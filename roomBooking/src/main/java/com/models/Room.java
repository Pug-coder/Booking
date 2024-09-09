package roomBooking.roomBooking.src.main.java.com.models;

import roomBooking.roomBooking.src.main.java.com.exceptions.BadRoomNumberException;
import roomBooking.roomBooking.src.main.java.com.exceptions.BookingConflictException;

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
        this.roomNumber = roomNumberValidator(roomNumber);
    }

    public ArrayList<Booking> getBookings() {
        return this.bookings;
    }

    public void addBooking(Booking newBooking) {
        if (checkRoomIsAvailable(newBooking)) {
            bookings.add(newBooking);
        }
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public void viewBookings() {
        if (getBookings().isEmpty()) {
            System.out.println("No bookings for this room");
        } else {
            for (Booking booking : getBookings()) {
                System.out.println(booking);
            }
        }
    }

    private int roomNumberValidator(int roomNumber) {
        if (roomNumber <= 0) {
            String exceptionMessage = String.format("Room number cannot be less than zero%nyour choice %s",
                    roomNumber);
            throw new BadRoomNumberException(exceptionMessage, roomNumber);
        } else {
            return roomNumber;
        }
    }
    public boolean checkRoomIsAvailable(Booking checkingBooking) {
        for (Booking booking : getBookings()) {
            if (checkingBooking.conflictsWith(booking)) {
                String exceptionMessage = String.format("Conflict with another booking%n %s - %s",
                        booking.getStartTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                        booking.getEndTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
                throw new BookingConflictException(exceptionMessage, booking);
            }
        }
        return true;
    }
}
