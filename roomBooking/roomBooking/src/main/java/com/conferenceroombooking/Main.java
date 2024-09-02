package roomBooking.roomBooking.src.main.java.com.conferenceroombooking;

import roomBooking.roomBooking.src.main.java.com.conferenceroombooking.models.Booking;
import roomBooking.roomBooking.src.main.java.com.conferenceroombooking.models.Room;
import roomBooking.roomBooking.src.main.java.com.conferenceroombooking.models.User;
import roomBooking.roomBooking.src.main.java.com.conferenceroombooking.services.BookingService;

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
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                }
            }
        }
    }
}