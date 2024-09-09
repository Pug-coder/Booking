package roomBooking;

import roomBooking.roomBooking.src.main.java.com.exceptions.*;
import roomBooking.roomBooking.src.main.java.com.models.Booking;
import roomBooking.roomBooking.src.main.java.com.models.Room;
import roomBooking.roomBooking.src.main.java.com.models.User;
import roomBooking.roomBooking.src.main.java.com.services.BookingService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private static BookingService bookingService = new BookingService();
    public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(500));
        rooms.add(new Room(501));


        for (Room room: rooms) {
            bookingService.addRoom(room);
        }

        ArrayList<Booking> room500Bookings = new ArrayList<>() {{
            add(new Booking(
                    "01-01-2024 14:00",
                    "01-01-2024 15:00",
                    new User("Biba", "Boba")
            ));
            add(new Booking(
                    "02-01-2024 10:00",
                    "02-01-2024 12:00",
                    new User("Flopa", "Shlepa")
            ));
            add(new Booking(
                    "03-01-2024 09:00",
                    "03-01-2024 11:00",
                    new User("John", "Doe")
            ));
        }};

        ArrayList<Booking> room501Bookings = new ArrayList<>() {{
            add(new Booking(
                    "04-01-2024 13:00",
                    "04-01-2024 14:30",
                    new User("Charlie", "Brown")
            ));
            add(new Booking(
                    "05-01-2024 16:00",
                    "05-01-2024 17:00",
                    new User("Emily", "Clark")
            ));
            add(new Booking(
                    "06-01-2024 08:00",
                    "06-01-2024 09:00",
                    new User("Michael", "Smith")
            ));
        }};

        for (Booking booking : room500Bookings) {
            bookingService.addBooking(
                    booking,
                    500
                    );
        }

        for (Booking booking : room501Bookings) {
            bookingService.addBooking(
                    booking,
                    501
            );
        }

        while (true) {
            System.out.println("1. Add booking");
            System.out.println("2. Delete Booking");
            System.out.println("3. View all chosen room bookings");
            System.out.println("4. View room list");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    String firstName = inputName("first name");
                    String lastName = inputName("last name");

                    User user = createUser(firstName, lastName);

                    String startTime = inputTime("start time");
                    String endTime = inputTime("end time");

                    Booking booking = createBooking(user, startTime, endTime);

                    int roomNumber = inputRoomNumber();
                    addBookingToRoom(booking, roomNumber);
                }
                case 2 -> {
                    /* думаю можно лучше удаление реализовать */
                    String firstName = inputName("first name");
                    String lastName = inputName("last name");

                    User user = createUser(firstName, lastName);

                    String startTime = inputTime("start time");
                    String endTime = inputTime("end time");

                    Booking booking = createBooking(user, startTime, endTime);

                    int roomNumber = inputRoomNumber();

                    removeBookingFromRoom(booking, roomNumber);
                }
                case 3 -> {
                    System.out.println("Chose room");
                    int roomNumber = scanner.nextInt();
                    bookingService.viewRoomBookings(roomNumber);
                }
                case 4 -> {
                    bookingService.viewRooms();
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
            }
        }
    }

    public static String inputName(String nameType) {
        System.out.println("Enter your " + nameType);
        return scanner.nextLine();
    }

    public static User createUser(String firstName, String lastName) {
        try {
            return new User(firstName, lastName);
        } catch (BadNameException e) {
            System.out.println(e.getMessage());
            if (Objects.equals(e.getWrongFieldName(), "First name")) {
                String updatedFirstName = inputName("First name");
                return createUser(updatedFirstName, lastName);

            }
            if (Objects.equals(e.getWrongFieldName(), "Last name")) {
                String updatedLastName = inputName("Last name");
                return createUser(firstName, updatedLastName);
            }
        }
        return null;
    }

    public static String inputTime(String time) {
        System.out.printf("Enter %s%n of format dd-MM-yyyy HH:mm%n", time);
        return scanner.nextLine();
    }

    public static Booking createBooking(User user, String startTime, String endTime) {
        try {
            return new Booking(startTime, endTime, user);
        } catch (BookingNullException e) {
            System.out.println(e.getMessage());
            if (Objects.equals(e.getFieldName(), "start time")) {
                String updatedStartTime = inputTime("start time");
                return createBooking(user, updatedStartTime, endTime);
            }
            if (Objects.equals(e.getFieldName(), "end time")) {
                String updatedEndTime = inputTime("end time");
                return createBooking(user, startTime, updatedEndTime);
            }
        } catch (BookingTimeException e) {
            System.out.println(e.getMessage());
            if (Objects.equals(e.getFieldName(), "start time")) {
                String updatedStartTime = inputTime("start time");
                return createBooking(user, updatedStartTime, endTime);
            }
            if (Objects.equals(e.getFieldName(), "end time")) {
                String updatedEndTime = inputTime("end time");
                return createBooking(user, startTime, updatedEndTime);
            }
        }
        return null;
    }
    public static int inputRoomNumber() {
        System.out.println("Enter room you want to reserve");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        return roomNumber;
    }

    public static void addBookingToRoom(Booking booking, int roomNumber) {
        try {
            bookingService.addBooking(booking, roomNumber);
        } catch (BookingConflictException e) {
            System.out.println(e.getMessage());

            String updatedStartTime = inputTime("start time");
            String updatedEndTime = inputTime("end time");

            Booking updatedBooking = createBooking(booking.getUser(),
                    updatedStartTime,
                    updatedEndTime);

            addBookingToRoom(updatedBooking, roomNumber);
        } catch (BadRoomNumberException | RoomNotFoundException e) {
            System.out.println(e.getMessage());
            int updatedRoomNumber = inputRoomNumber();
            addBookingToRoom(booking, updatedRoomNumber);
        }
    }

    public static void removeBookingFromRoom(Booking booking, int roomNumber) {
        try {
            bookingService.removeBooking(booking, roomNumber);
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
            int updatedRoomNumber = inputRoomNumber();
            removeBookingFromRoom(booking, updatedRoomNumber);
        }
    }
}