package roomBooking.roomBooking.src.main.java.com.services;

import roomBooking.roomBooking.src.main.java.com.exceptions.RoomNotFoundException;
import roomBooking.roomBooking.src.main.java.com.models.Booking;
import roomBooking.roomBooking.src.main.java.com.models.Room;
import roomBooking.roomBooking.src.main.java.com.models.User;

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

        return null;
    }

    public void viewRoomBookings(int roomNumber) {
        Room foundedRoomNumber = findRoom(roomNumber);
        if (foundedRoomNumber != null) {
            foundedRoomNumber.viewBookings();
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

    public void addBooking(Booking booking, int roomNumber) {
        //Booking booking = new Booking(startTime, endTime, user);
        Room room = findRoom(roomNumber);
        if (room != null) {
            room.addBooking(booking);
        } else {
            throw new RoomNotFoundException("Can't found room " + roomNumber, roomNumber);
        }
    }

    public void removeBooking(Booking booking, int roomNumber) {
        Room currentRoom = findRoom(roomNumber);
        if (currentRoom != null) {
            currentRoom.removeBooking(booking);
        } else {
            throw new RoomNotFoundException("Can't found room " + roomNumber, roomNumber);
        }
    }
    /*
        + просмотр комнат
        + просмотр записи в комнате
        + создать комнату
        + удалить комнату
        + добавить запись
        + удалить запись

     */

}
