package roomBooking.roomBooking.src.main.java.com.exceptions;

public class BadNameException extends RuntimeException {
    private final String wrongFieldName;
    public BadNameException(String fieldName, String message) {
        super(message);
        wrongFieldName = fieldName;
    }

    public String getWrongFieldName() {
        return wrongFieldName;
    }
}
