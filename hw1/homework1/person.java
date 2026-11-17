package hw1.homework1;

public class person {
    private String name; // Person's name
    private String surname; // Person's surname
    private String address; // Person's address
    private String phone; // Person's phone number
    private int ID; // Person's ID

    // Constructor
    public person(String name, String surname, String address, String phone, int ID) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.ID = ID;
    }

    // Getter methods
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getphone() {
        return phone;
    }
}

