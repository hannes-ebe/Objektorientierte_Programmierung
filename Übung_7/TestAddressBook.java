import addressBook.AddressBook;
/** Class to test the class AddressBook. */
public class TestAddressBook {
    /* Die main-methode enthält mindestens einen Aufruf jeder Funktion. Interaktiv können alle möglichen Sonderfälle
    getestet werden.
     */
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
