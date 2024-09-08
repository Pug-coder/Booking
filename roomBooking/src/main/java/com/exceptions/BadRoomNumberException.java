package roomBooking.roomBooking.src.main.java.com.exceptions;

public class BadRoomNumberException extends RuntimeException{
    private final int roomNumber;
    public BadRoomNumberException(String message, int roomNumber) {
        super(message);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
