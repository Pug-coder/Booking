package roomBooking.roomBooking.src.main.java.com.exceptions;

import roomBooking.roomBooking.src.main.java.com.models.Booking;

public class BookingConflictException extends RuntimeException {
    private final Booking conflictBooking;

    public BookingConflictException(String message, Booking conflictBooking) {
        super(message);
        this.conflictBooking = conflictBooking;
    }

    public Booking getConflictBooking() {
        return conflictBooking;
    }
}
