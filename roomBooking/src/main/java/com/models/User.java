package roomBooking.roomBooking.src.main.java.com.models;

public class User {
    private String name, surname;

    public User(String name, String surname) {
        setName(name);
        setSurname(surname);
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n Surname: %s\n", name, surname);
    }
}
