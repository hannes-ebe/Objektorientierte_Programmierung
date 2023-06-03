package addressBook;
/** A class to implement a name.*/
class Name {
    /** First name of name */
    private String firstName;
    /** Last name of name. */
    private String lastName;
    /** Constructor for a name */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /** Method to get first name. */
    public String getFirstName() {
        return firstName;
    }
    /** Method to get last name. */
    public String getLastName() {
        return lastName;
    }
    /** Method to set first name. */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /** Method to set last name. */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /** Method to print a name. */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
