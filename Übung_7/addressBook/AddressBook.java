package addressBook;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
/** Class to implement an address book. */
public class AddressBook {
    /** ArrayList of contacts. */
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    /** Method to add a contact. It can be chosen between adding a person or a company.
     * The parameters have to be entered using the shell.
     * Entering Null instead of entering the first name or the city leaves the entries for
     * the name or the address empty. It is only possible to leave the address or name as a whole empty,
     * not only parts of the address or name.
     */
    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        // Variablen mit dem Präfix "super" korrespondieren zur Eingabe, ob es sich um eine Person oder eine Firma handelt.
        boolean superInput = true;

        while (superInput){
            System.out.println("What kind of contact do you want to add? Enter 1 for a person or 2 for a company:");
            String kindOfContact = scanner.nextLine();
            switch (kindOfContact) {
                case "1":
                    Person newPerson = new Person();

                    // Entering the name:
                    System.out.println("Enter the first name or enter Null to leave the name of the person empty:");
                    String firstNameInput = scanner.nextLine();
                    if (!Objects.equals(firstNameInput, "Null")) {
                        System.out.println("Enter the last name:");
                        String lastNameInput = scanner.nextLine();
                        newPerson.setName(new Name(firstNameInput,lastNameInput));
                    }

                    // Entering the address:
                    System.out.println("What is the address of your person?");
                    System.out.println("Enter a city or enter Null to leave the address of the person empty:");
                    String cityInput = scanner.nextLine();
                    if (!Objects.equals(cityInput, "Null")) {
                        System.out.println("Enter the postal code (must be an integer):");
                        boolean falseInput = true;
                        int postalCodeInput = 0;

                        // Durchlaufe while-Schleife bis der korrekte Input eingegeben wurde.
                        while (falseInput) {
                            try {
                                Scanner scanner1 = new Scanner(System.in);
                                postalCodeInput = scanner1.nextInt();
                                falseInput = false;
                            } catch (InputMismatchException e){
                                System.out.println("The input must be an integer. Please try again:");
                            }
                        }
                        System.out.println("Enter the street:");
                        String streetInput = scanner.nextLine();
                        System.out.println("Enter the house number (must be an integer):");
                        falseInput = true;
                        int houseNumberInput = 0;

                        // Durchlaufe while-Schleife bis der korrekte Input eingegeben wurde.
                        while (falseInput) {
                            try {
                                Scanner scanner1 = new Scanner(System.in);
                                houseNumberInput = scanner1.nextInt();
                                falseInput = false;
                            } catch (InputMismatchException e){
                                System.out.println("The input must be an integer. Please try again:");
                            }
                        }
                        newPerson.setAddress(new Address(cityInput,postalCodeInput,streetInput,houseNumberInput));
                    }

                    contacts.add(newPerson);
                    superInput = false;
                    break;

                case "2":
                    Company newCompany = new Company();

                    // Entering the company name:
                    System.out.println("Enter the name of the company or enter Null to leave the name of the company empty:");
                    String companyNameInput = scanner.nextLine();
                    if (!Objects.equals(companyNameInput, "Null")) {
                        newCompany.setCompanyName(companyNameInput);
                    }

                    // Entering the name of the company owner:
                    System.out.println("Enter the first name of the company owner or enter Null to leave the name of the owner empty:");
                    String ownerFirstNameInput = scanner.nextLine();
                    if (!Objects.equals(ownerFirstNameInput, "Null")) {
                        System.out.println("Enter the last name of the owner:");
                        String ownerLastNameInput = scanner.nextLine();
                        newCompany.setName(new Name(ownerFirstNameInput,ownerLastNameInput));
                    }

                    // Entering the address of the company:
                    System.out.println("What is the address of your contact?");
                    System.out.println("Enter a city or enter Null to leave the address of the company empty:");
                    String companyCityInput = scanner.nextLine();
                    if (!Objects.equals(companyCityInput, "Null")) {
                        System.out.println("Enter the postal code (must be an integer):");
                        boolean falseInput = true;
                        int companyPostalCodeInput = 0;

                        // Durchlaufe while-Schleife bis der korrekte Input eingegeben wurde.
                        while (falseInput) {
                            try {
                                Scanner scanner1 = new Scanner(System.in);
                                companyPostalCodeInput = scanner1.nextInt();
                                falseInput = false;
                            } catch (InputMismatchException e){
                                System.out.println("The input must be an integer. Please try again:");
                            }
                        }
                        System.out.println("Enter the street:");
                        String companyStreetInput = scanner.nextLine();
                        System.out.println("Enter the house number (must be an integer):");
                        falseInput = true;
                        int companyHouseNumberInput = 0;

                        // Durchlaufe while-Schleife bis der korrekte Input eingegeben wurde.
                        while (falseInput) {
                            try {
                                Scanner scanner1 = new Scanner(System.in);
                                companyHouseNumberInput = scanner1.nextInt();
                                falseInput = false;
                            } catch (InputMismatchException e){
                                System.out.println("The input must be an integer. Please try again:");
                            }
                        }
                        newCompany.setAddress(new Address(companyCityInput,companyPostalCodeInput,companyStreetInput,companyHouseNumberInput));
                    }

                    contacts.add(newCompany);
                    superInput = false;
                    break;

                default:
                    System.out.println("Invalid Input. Please try again:");
            }
        }
    }

    /**
     * Method to delete a contact from the address book. The operation can be cancelled by entering -1.
     * If the input is  invalid the method asks for a new input.
     */
    public void deleteContact() {
        System.out.println("Which of the following entries do you want to delete?\nPlease enter the corresponding index number or -1 to cancel the operation:");
        this.printContacts();
        boolean falseInput = true;
        while (falseInput) {
            try {
                Scanner scanner1 = new Scanner(System.in);
                int index = scanner1.nextInt();
                if (index == -1) {
                    System.out.println("Operation cancelled. No entry has been deleted.");
                    break;
                }
                contacts.remove(index);
                System.out.println("The following contact has been deleted: "+index);
                falseInput = false;
            } catch (InputMismatchException e) {
                System.out.println("The input must be a valid index number or -1 to cancel the operation. Please try again:");
            }
        }
    }

    /**
     * Method to print all contacts of the address book. The index number of each entry is provided.
     */
    public void printContacts() {
        System.out.println("Printing address book:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("Entry " + i + ":");
            System.out.println(contacts.get(i));
            System.out.println();
        }
    }

    /**
     * Method to search for a specific string in all entries of the address book.
     * The string can be part of a larger word.
     * @param s The String which shall be searched for in the address book.
     */
    public void search(String s) {
        /* Mit einer Schleife werden alle Einträge des Adressbuches durchlaufen und überprüft, ob sie das
        gesuchte String-Fragment enthalten. Dabei muss das Fragment kein ganzes Wort sein, sondern kann auch Teil
        eines längeren Wortes sein. Mit der contains-Methode wird überprüft, ob die String-Ausgabe des
        Kontakts das Fragment enthält.
         */
        System.out.println("Searching for \"" + s + "\" in the address book resulted in the following contacts:");
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).toString().contains(s)) {
                System.out.println("Entry " + i + ":");
                System.out.println(contacts.get(i));
                System.out.println();
            }
        }
    }
}
