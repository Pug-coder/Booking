package roomBooking.roomBooking.src.main.java.com.exceptions;

import roomBooking.roomBooking.src.main.java.com.models.Booking;

public class BookingTimeException extends RuntimeException {
    private final Booking conflictBooking;

    public BookingTimeException(String message, Booking conflictBooking) {
        super(message);
        this.conflictBooking = conflictBooking;
    }

    public Booking getConflictBooking() {
        return conflictBooking;
    }
}
