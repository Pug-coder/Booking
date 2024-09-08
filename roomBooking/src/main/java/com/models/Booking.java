package roomBooking.roomBooking.src.main.java.com.models;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

public class Booking {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private User user;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Booking(String startTime, String endTime, User user) {
        setStartTime(startTime);
        setEndTime(endTime);
        setUser(user);
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = validateTime(startTime, "start time");
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = validateTime(endTime, "end time");
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private LocalDateTime validateTime(String time, String fieldName) {
        try {
            return LocalDateTime.parse(time, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Date and time format must be 'dd-MM-yyyy HH:mm'.");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty.");
        }
    }

    public boolean conflictsWith(Booking checkedBooking) {
        return getStartTime().isBefore(checkedBooking.getEndTime()) && getEndTime().isAfter(checkedBooking.getStartTime());
    }

    @Override
    public String toString() {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return String.format("Booking{\nUser: %sstartTime: %s\n endTime: %s",
                getUser(),
                getStartTime().format(formatter),
                getEndTime().format(formatter));
    }
}
