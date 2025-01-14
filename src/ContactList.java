import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Celebrity");

        Scanner s = new Scanner(System.in);
        int type = s.nextInt();

        if (type == 1) {
            getStudentInfo();
        }
        else if (type == 2){
            getCelebrityInfo();
        }
        else {
            // TODO: Do we have to have an else?
        }

    }

    public void getStudentInfo() {
        Person p = getPersonInfo();

        Scanner s = new Scanner(System.in);
        System.out.println("Grade: ");
        int grade = s.nextInt();

        Student student = new Student(p.getFirstName(), p.getLastName(), p.getPhoneNumber(), grade);
        contacts.add(student);
    }

    public void getCelebrityInfo() {
        Person p = getPersonInfo();

        Scanner s = new Scanner(System.in);
        System.out.println("Occupation: ");
        String occupation = s.nextLine();

        Celebrity celeb = new Celebrity(p.getFirstName(), p.getLastName(), p.getPhoneNumber(), occupation);
        contacts.add(celeb);
    }

    public Person getPersonInfo() {
        System.out.println("Please fill in the following information.");
        System.out.println("First Name: ");
        Scanner s = new Scanner(System.in);
        String firstName = s.nextLine();

        System.out.println("Last Name: ");
        String lastName = s.nextLine();

        System.out.println("Phone Number: ");
        String phone = s.nextLine();

        return new Person(firstName, lastName, phone);
    }

    public void printContacts() {
        // TODO
        for (Person p : contacts) {
           System.out.println(p.toString());
        }
    }


}
