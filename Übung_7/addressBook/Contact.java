package addressBook;
/** A class to implement a contact. */
abstract class Contact {
    /** Name of the contact. */
    private Name name;
    /** Address of the contact. */
    private Address address;
    /** Method to get the name of the contact. */
    private Name getName() {
        return name;
    }
    /** Method to set the name of the contact. */
    void setName(Name name) {
        this.name = name;
    }
    /** Method to get the address of the contact. */
    Address getAddress() {
        return address;
    }
    /** Method to set the address of the contact. */
    void setAddress(Address address) {
        this.address = address;
    }
    /** Method to print a contact. */
    @Override
    public String toString() {
        /* Abfrage, ob name oder address null sind. In diesem Fall soll auch null für sie ausgegeben werden,
        da die toString-Methode dann nicht funktioniert. */
        String nameVariable;
        String addressVariable;
        if (name == null) {
            nameVariable = null;
        }
        else {
            nameVariable = name.toString();
        }
        if (address == null) {
            addressVariable = null;
        }
        else {
            addressVariable = address.toString();
        }
        return nameVariable + "\nAddress: " + addressVariable;
    }
}
