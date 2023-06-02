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

    private void addContact() {
        System.out.println("What kind of contact do you want to add? Enter 1 for a person or 2 for a company:");
        Scanner scanner = new Scanner(System.in);
        String kindOfContact = scanner.next();
        switch (kindOfContact) {
            case "1":
                System.out.println("Enter the first name (Enter Null to skip this entry):");
                System.out.println("Enter the last name (Enter Null to skip this entry):");
                break;
            case "2":
                int i;
                break;
                default:
                    System.out.println("Invalid Input. Please try again:");
        }
    }
    private void deleteContact() {

    }
    private void printContacts() {

    }
    private void search(String s) {
        // Idee ist die Einträge zu printen...
    }
}
