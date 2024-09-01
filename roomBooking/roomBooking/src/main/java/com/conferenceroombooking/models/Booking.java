package main.java.com.conferenceroombooking.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Booking {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private User user;

    public Booking(LocalDateTime startTime, LocalDateTime endTime, User user) {
        setStartTime(startTime);
        setEndTime(endTime);
        setUser(user);
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean conflictsWith(Booking checkedBooking) {
        return startTime.isBefore(checkedBooking.getEndTime()) && endTime.isAfter(checkedBooking.getStartTime());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return String.format("Booking{\nUser: %s\nstartTime: %s\n endTime: %s",
                user,
                startTime.format(formatter),
                endTime.format(formatter));
    }
}
