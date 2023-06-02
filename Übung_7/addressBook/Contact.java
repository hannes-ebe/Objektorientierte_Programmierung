package addressBook;
/** A class to implement a contact. */
public class Contact {
    /** Name of the contact. */
    private Name name;
    /** Address of the contact. */
    private Address address;
    /** Function to get the name of the contact. */
    public Name getName() {
        return name;
    }
    /** Function to set the name of the contact. */
    public void setName(Name name) {
        this.name = name;
    }
    /** Function to get the address of the contact. */
    public Address getAddress() {
        return address;
    }
    /** Function to set the address of the contact. */
    public void setAddress(Address address) {
        this.address = address;
    }
    /** Function to print a contact. */
    @Override
    public String toString() {
        return name.toString() + "\n" + address.toString();
    }
}
