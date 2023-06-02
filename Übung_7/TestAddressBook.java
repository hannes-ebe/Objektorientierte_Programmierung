import addressBook.AddressBook;
/** Class to test the class AddressBook. */
public class TestAddressBook {
    public static void main(String[] args) {
        private int numberOfContacts = 3;
        AddressBook addressBook = new AddressBook(numberOfContacts);
        addressBook.addContact();
        addressBook.printContacts();
        addressBook.search("Christian-Albrechts-Platz");
        addressBook.deleteContact();
    }
}
