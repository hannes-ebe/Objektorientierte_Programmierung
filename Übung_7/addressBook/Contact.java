package addressBook;
/** A class to implement a contact. */
public abstract class Contact {
    /** Name of the contact. */
    private Name name;
    /** Address of the contact. */
    Address address;
    /** Function to get the name of the contact. */
    Name getName() {
        return name;
    }
    /** Function to set the name of the contact. */
    void setName(Name name) {
        this.name = name;
    }
    /** Function to get the address of the contact. */
    Address getAddress() {
        return address;
    }
    /** Function to set the address of the contact. */
    void setAddress(Address address) {
        this.address = address;
    }
    /** Function to print a contact. */
    @Override
    String toString() {
        return name.toString() + "\n" + address.toString();
    }
}
