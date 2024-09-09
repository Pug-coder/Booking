package roomBooking.roomBooking.src.main.java.com.exceptions;

public class BookingNullException extends RuntimeException {
    private final String fieldName;
    public BookingNullException(String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
