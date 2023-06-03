import addressBook.AddressBook;
/** Class to test the class AddressBook. */
public class TestAddressBook {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
        addressBook.addContact();
        addressBook.addContact();
        addressBook.printContacts();
        addressBook.search("Tom");
        addressBook.deleteContact();
        addressBook.printContacts();
    }
}
