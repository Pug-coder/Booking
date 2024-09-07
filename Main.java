package roomBooking;

import roomBooking.roomBooking.src.main.java.com.models.Booking;
import roomBooking.roomBooking.src.main.java.com.models.Room;
import roomBooking.roomBooking.src.main.java.com.models.User;
import roomBooking.roomBooking.src.main.java.com.services.BookingService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO: filling base
        ArrayList<User> users = new ArrayList<User>();

        ArrayList<Booking> bookings = new ArrayList<Booking>();
        ArrayList<Room> rooms = new ArrayList<Room>();

        BookingService bookingService = new BookingService();


        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Add booking");
            System.out.println("3. View all chosen room bookings");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Adding new user");
                    System.out.println("Enter name: ");
                    String userName = scanner.nextLine();

                    System.out.println("Enter surname: ");
                    String userSurname = scanner.nextLine();

                    users.add(new User(userName, userSurname));
                    System.out.println(users);
                }
                case 2 -> {
                    System.out.println("Adding new booking");

                    System.out.print("Enter start time (dd-MM-yyyy HH:mm): ");
                    String startTimeString = scanner.nextLine();
                    System.out.print("Enter end time (dd-MM-yyyy HH:mm): ");
                    String endTimeString = scanner.nextLine();

                    LocalDateTime startTime = LocalDateTime.parse(startTimeString, formatter);
                    LocalDateTime endTime = LocalDateTime.parse(endTimeString, formatter);

                    System.out.println("Enter user: ");
                    System.out.println("Enter name: ");
                    String userName = scanner.nextLine();

                    System.out.println("Enter surname: ");
                    String userSurname = scanner.nextLine();

                    User user = new User(userName, userSurname);
                    if (!users.contains(user)) {
                        users.add(user);
                    }

                    Booking booking = new Booking(startTime, endTime, user);

                    bookings.add(booking);

                    System.out.println(bookings);
                }
                case 3 -> {
                }
                case 4 -> {
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                }
            }
        }
    }
}