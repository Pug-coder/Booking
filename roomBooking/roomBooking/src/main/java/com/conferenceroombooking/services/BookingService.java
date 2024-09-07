package roomBooking.roomBooking.src.main.java.com.conferenceroombooking.services;

import roomBooking.roomBooking.src.main.java.com.conferenceroombooking.models.Booking;
import roomBooking.roomBooking.src.main.java.com.conferenceroombooking.models.Room;
import roomBooking.roomBooking.src.main.java.com.conferenceroombooking.models.User;

import java.time.LocalDateTime;
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

    private Room findRoom(int roomNumber) {
        Room foundedRoomNumber;

        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                foundedRoomNumber = room;
                return foundedRoomNumber;
            }
        }

        System.out.println("Room not found");
        return null;
    }

    public void viewRoomBookings(int roomNumber) {
        Room foundedRoomNumber = findRoom(roomNumber);
        if (foundedRoomNumber != null) {
            for (Booking booking : foundedRoomNumber.getBookings()) {
                System.out.printf("%s - %s%n",
                        booking.getStartTime(),
                        booking.getEndTime());
            }
        }
    }

    public void addRoom(Room newRoom) {
        if (findRoom(newRoom.getRoomNumber()) == null) {
            rooms.add(newRoom);
        }
    }

    public void removeRoom(Room room) {
        if (findRoom(room.getRoomNumber()) != null) {
            rooms.remove(room);
        }
    }

    public void addBooking(User user, LocalDateTime startTime, LocalDateTime endTime, int roomNumber) {
        Booking booking = new Booking(startTime, endTime, user);
        Room room = new Room(roomNumber);
        room.addBooking(booking);
        BookingService meetingRoom = new BookingService();
        meetingRoom.addRoom(room);
    }

    public void removeBooking(int roomNumber, Booking booking) {
        Room currentRoom = findRoom(roomNumber);
        if (currentRoom != null) {
            currentRoom.removeBooking(booking);
        }
    }
    /*
        + просмотр комнат
        + просмотр записи в комнате
        + создать комнату
        + удалить комнату
        + добавить запись
        удалить запись

     */

}
