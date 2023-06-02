package addressBook;
import java.util.Scanner;
/** Class to implement an address book. */
public class AddressBook {
    /** Maximum number of contacts in the address book. */
    private int maxNumberOfContacts;
    /** Current number of contacts in the address book. */
    private int numberOfContacts = 0;
    /** ArrayList of contacts. */
    private Contact[] contacts = new Contact[maxNumberOfContacts];
    /** Constructor to initialize an address book. */
    public AddressBook(int maxNumberOfContacts) {
        this.maxNumberOfContacts = maxNumberOfContacts;
    }

    /** Function to add a contact. It can be chosen between adding a person or a company.
     * Entering Null instead of entering the first name or the city leaves the entries for
     * the name or the address empty.
     */
    public void addContact() {
        if (numberOfContacts == maxNumberOfContacts) {
            System.out.println("The maximum number of contacts has already been reached for this address book.");
        }
        else {
            System.out.println("What kind of contact do you want to add? Enter 1 for a person or 2 for a company:");
            Scanner scanner = new Scanner(System.in);
            String kindOfContact = scanner.next();
            switch (kindOfContact) {
                case "1":
                    contacts[numberOfContacts] = new Person();
                    System.out.println("Enter the first name or enter Null to leave the name of the contact empty:");
                    String firstInput = scanner.next();
                    if (firstInput != "Null") {
                        System.out.println("Enter the last name:");
                        String secondInput = scanner.next();
                        contacts[numberOfContacts].setName(new Name(firstInput,secondInput));
                    }
                    System.out.println("What is the address of your contact?");
                    System.out.println("Enter a city or enter Null to leave the address of the contact empty:");

                    numberOfContacts += 1;
                    break;
                case "2":
                    numberOfContacts += 1;
                    break;
                default:
                    System.out.println("Invalid Input. Please try again:");
            }
        }
    }
    public void deleteContact() {

    }
    public void printContacts() {

    }
    public void search(String s) {
        // Idee ist die Einträge zu printen...
    }
}
