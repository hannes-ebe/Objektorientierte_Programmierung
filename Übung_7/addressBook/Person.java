package addressBook;
/** Class to implement a person */
class Person extends Contact {
    /** Method to print a person. */
    @Override
    public String toString() {
        return "Person: " + super.toString();
    }
}
