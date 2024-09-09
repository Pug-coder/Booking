package roomBooking.roomBooking.src.main.java.com.exceptions;

public class BookingTimeException extends RuntimeException {
    private final String fieldName;
    public BookingTimeException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
