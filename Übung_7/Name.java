/** A class to implement a name.*/
public class Name {
    /** First name of name */
    private String firstName;
    /** Last name of name. */
    private String lastName;
    /** Constructor for a name */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /** Function to get first name. */
    public String getFirstName() {
        return firstName;
    }
    /** Function to get last name. */
    public String getLastName() {
        return lastName;
    }
    /** Function to set first name. */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /** Function to set last name. */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /** Function to print a name. */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
