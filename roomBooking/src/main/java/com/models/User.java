package roomBooking.roomBooking.src.main.java.com.models;

import roomBooking.roomBooking.src.main.java.com.exceptions.BadNameException;

public class User {
    private String firstName, lastName;

    public User(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = validateName(firstName, "First name");
    }

    public void setLastName(String lastName) {
        this.lastName = validateName(lastName, "Last name");
    }


    private String validateName(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            String exceptionMessage = String.format("%s cannot be null or empty", fieldName);
            throw new BadNameException(fieldName, exceptionMessage);
        }
        return name;
    }

    /* в Booking можно сделать, а тут try catch*/
    public User changeFirstName(String firstName) {
        String newFirstName = validateName(firstName, "First name");
        return new User(newFirstName, getLastName());
    }

    public User changeLastName(String lastName) {
        String newLastName = validateName(lastName, "Last name");
        return new User(getFirstName(), newLastName);
    }

    @Override
    public String toString() {
        return String.format("firstName: %s\n lastName: %s\n", getFirstName(), getLastName());
    }
}
