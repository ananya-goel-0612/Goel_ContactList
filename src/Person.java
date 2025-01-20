// Class to instantiate a person
public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor for the person class
    // Initializes the first name, last name, and phone number
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Prints out all attributes of a person
    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
