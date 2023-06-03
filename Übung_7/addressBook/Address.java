package addressBook;
/** A class to implement an address. */
class Address {
    /** City of address */
    private String city;
    /** Postal code of address */
    private int postalCode;
    /** Street of address */
    private String street;
    /** House number of address */
    private int houseNumber;
    /** Constructor for an address */
    Address(String city, int postalCode, String street, int houseNumber) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.houseNumber = houseNumber;
    }
    /** Method to get city. */
    String getCity() {
        return city;
    }
    /** Method to set city. */
    void setCity(String city) {
        this.city = city;
    }
    /** Method to get postal code. */
    int getPostalCode() {
        return postalCode;
    }
    /** Method to set postal code. */
    void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    /** Method to get street. */
    String getStreet() {
        return street;
    }
    /** Method to set street. */
    void setStreet(String street) {
        this.street = street;
    }
    /** Method to get house number. */
    int getHouseNumber() {
        return houseNumber;
    }
    /** Method to set house number. */
    void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    /** Method to print an address. */
    @Override
    public String toString() {
        return postalCode + " " + city + ", " + street + " " + houseNumber;
    }
}
