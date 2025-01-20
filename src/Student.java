// Student class that contains all attributes of a person as well as a grade level
public class Student extends Person {
    private int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        // Calls the constructor in the super class (Person class)
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    // Prints out the super class' toString as well as the grade level
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
