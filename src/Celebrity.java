// Celebrity class contains all attributes of a person as well as an occupation
public class Celebrity extends Person{
    private String occupation;

    public Celebrity(String firstName, String lastName, String phoneNumber, String occupation) {
        // Call to the super class (Person)
        super(firstName, lastName, phoneNumber);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    // Prints the super class' toString and prints out the occupation as well
    public String toString() {
        return super.toString() + " Occupation: " + occupation;
    }
}
