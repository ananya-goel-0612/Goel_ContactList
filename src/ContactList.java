import java.util.ArrayList;
import java.util.Scanner;

// Class that contains the main method to run all other methods
public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        // Initializes the ArrayList of contacts
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // When the user chooses to add a new contact, get all the information needed
    // To initialize an instance of the Person class
    public void addContact() {
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Celebrity");

        Scanner s = new Scanner(System.in);
        int type = s.nextInt();

        // Run getStudentInfo() if the user chooses to add a Student
        if (type == 1) {
            getStudentInfo();
        }
        // Run getCelebrityInfo() if the user chooses to add a Celebrity
        else if (type == 2){
            getCelebrityInfo();
        }
        // Otherwise create a new Person
        else {
            Person person = getPersonInfo();
            contacts.add(person);
        }
    }

    public void getStudentInfo() {
        // Gets the information required to create a new Person
        Person p = getPersonInfo();

        // Also receives the grade level of the student
        Scanner s = new Scanner(System.in);
        System.out.println("Grade: ");
        int grade = s.nextInt();

        // Instantiates a new Student based on the information given
        Student student = new Student(p.getFirstName(), p.getLastName(), p.getPhoneNumber(), grade);
        contacts.add(student);
    }

    public void getCelebrityInfo() {
        // Gets the information required to create a new Person
        Person p = getPersonInfo();

        // Also gets the celebrity's occupation
        Scanner s = new Scanner(System.in);
        System.out.println("Occupation: ");
        String occupation = s.nextLine();

        // Instantiates a new celebrity based on the information given
        Celebrity celeb = new Celebrity(p.getFirstName(), p.getLastName(), p.getPhoneNumber(), occupation);
        contacts.add(celeb);
    }

    // Every single student and celebrity needs to have a Person's attributes
    // So this method gets all the required information to instantiate a Person
    public Person getPersonInfo() {
        System.out.println("Please fill in the following information.");
        System.out.println("First Name: ");
        Scanner s = new Scanner(System.in);
        String firstName = s.nextLine();

        System.out.println("Last Name: ");
        String lastName = s.nextLine();

        System.out.println("Phone Number: ");
        String phone = s.nextLine();

        // Returns the Person that was created
        return new Person(firstName, lastName, phone);
    }

    // Prints out all the contacts that have been added
    public void printContacts() {
        for (Person person : contacts) {
            // Prints the toString() for each contact
            System.out.println(person.toString());
        }
    }

    // Method to sort the contacts, depending on what the user inputs
    public void sort(int sortBy) {
        // Sorts by first name (alphabetical)
        if (sortBy == 0) {
            sortByFirstName();
        }
        // Sorts by last name (alphabetical)
        else if (sortBy == 1) {
            sortByLastName();
        }
        // Sorts by phone number (numerical)
        else if (sortBy == 2) {
            sortByPhoneNumber();;
        }
    }

    // Bubble sort method to sort the contacts by first name
    public void sortByFirstName() {
        for (Person p : contacts){
            for (int i = 0; i < contacts.size() - 1; i++){
                Person temp;
                String name1 = contacts.get(i).getFirstName().toLowerCase();
                String name2 = contacts.get(i + 1).getFirstName().toLowerCase();

                // Swaps the location of the two "people" if the second first name should come earlier
                if (name1.compareTo(name2) > 0){
                    temp = contacts.get(i);
                    contacts.set(i,contacts.get(i + 1));
                    contacts.set(i + 1, temp);
                }
            }
        }
    }

    // Bubble sort method to sort the contacts by last name
    public void sortByLastName() {
        for (Person p : contacts){
            for (int i = 0; i < contacts.size() - 1; i++){
                Person temp;
                String name1 = contacts.get(i).getLastName().toLowerCase();
                String name2 = contacts.get(i + 1).getLastName().toLowerCase();

                // Swaps the location of the two "people" if the second last name should come earlier
                if(name1.compareTo(name2) > 0){
                    temp = contacts.get(i);
                    contacts.set(i,contacts.get(i + 1));
                    contacts.set(i + 1, temp);
                }
            }
        }
    }

    // Bubble sort method to sort the contacts by phone number
    public void sortByPhoneNumber() {
        for (Person p : contacts){
            for (int i = 0; i < contacts.size() - 1; i++){
                Person temp;

                // Swaps the location of the two "people" if the second phone number is less than
                // The first
                if(contacts.get(i).getPhoneNumber().compareTo(contacts.get(i + 1).getPhoneNumber()) > 0){
                    temp = contacts.get(i);
                    contacts.set(i,contacts.get(i + 1));
                    contacts.set(i + 1,temp);
                }
            }
        }
    }

    // Searches the list of contacts to see if there's a match for the inputted first name
    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            // If a match is found, return the person
            if (p.getFirstName().equalsIgnoreCase(firstName)) {
                return p;
            }
        }
        // If no match is found, null should be returned
        return null;
    }

    // Searches the list of contacts to see if there's a match for the inputted last name
    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            // If a match is found, return the person
            if (p.getLastName().equalsIgnoreCase(lastName)) {
                return p;
            }
        }
        // If no match is found, null should be returned
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student) {
                System.out.println(p.toString());
            }
        }
    }

    public void run() {
        while (true) {
            int choice = 0;
            printConsole();
            Scanner s = new Scanner(System.in);

            // Make sure the user selects a number in menu
            while (true) {
                choice = s.nextInt();
                s.nextLine();

                if (choice >= 0 && choice < 9) {
                    break;
                }
                else {
                    printConsole();
                }
            }

            if (choice == 1) {
                addContact();
            }
            else if (choice == 2) {
                sort(0);
                printContacts();
            }
            else if (choice == 3) {
                sort(1);
                printContacts();
            }
            else if (choice == 4) {
                sort(2);
                printContacts();
            }
            else if (choice == 5) {
                listStudents();
            }
            else if (choice == 6) {
                System.out.println("Enter a first name: ");
                String name = s.nextLine();

                Person p = searchByFirstName(name);

                if (p != null) {
                    System.out.println(p.toString());
                }
                else {
                    System.out.println(name + " is not in the list");
                }
            }
            else if (choice == 7) {
                System.out.println("Enter a last name: ");
                String name = s.nextLine();

                Person p = searchByLastName(name);

                if (p != null) {
                    System.out.println(p.toString());
                }
                else {
                    System.out.println(name + " is not in the list");
                }
            }
            else if (choice == 8) {
                System.out.println("Enter a phone number: ");
                String number = s.nextLine();

                if (searchByPhoneNumber(number) == null) {
                    System.out.println(number + " is not in the list");
                }
                else {
                    System.out.println(searchByPhoneNumber(number));
                }
            }
            else {
                break;
            }
        }
    }

    public void printConsole() {
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        ContactList list = new ContactList();
        list.run();

    }
}
