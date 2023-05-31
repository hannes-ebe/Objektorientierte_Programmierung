/** A class to implement an address. */
public class Address {
    /** Country of address */
    private String country;
    /** City of address */
    private String city;
    /** Postal code of address */
    private int postalCode;
    /** Street of address */
    private String street;
    /** House number of address */
    private int houseNumber;
    /** Constructor for an address */
    public Address(String country, String city, int postalCode, String street, int houseNumber) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.houseNumber = houseNumber;
    }
    /** Function to get city. */
    public String getCity() {
        return city;
    }
    /** Function to set city. */
    public void setCity(String city) {
        this.city = city;
    }
    /** Function to get postal code. */
    public int getPostalCode() {
        return postalCode;
    }
    /** Function to set postal code. */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    /** Function to get street. */
    public String getStreet() {
        return street;
    }
    /** Function to set street. */
    public void setStreet(String street) {
        this.street = street;
    }
    /** Function to get house number. */
    public int getHouseNumber() {
        return houseNumber;
    }
    /** Function to set house number. */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    /** Function to get country. */
    public String getCountry() {
        return country;
    }
    /** Function to set country. */
    public void setCountry(String country) {
        this.country = country;
    }
    /** Function to print an address. */
    @Override
    public String toString() {
        return country + ", " + postalCode + " " + city + ", " + street + " " + houseNumber;
    }
}
