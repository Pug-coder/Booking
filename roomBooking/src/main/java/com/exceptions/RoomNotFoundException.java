package roomBooking.roomBooking.src.main.java.com.exceptions;

public class RoomNotFoundException extends RuntimeException {
    private final int roomNumber;
    public RoomNotFoundException(String message, int roomNumber) {
        super(message);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
