package addressBook;
/** Class to implement a company */
class Company extends Contact {
    /** Name of the company */
    private String companyName;
    /** Method to get the name of the company. */
    String getCompanyName() {
        return companyName;
    }
    /** Method to set the name of the company. */
    void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    /** Method to print the name of the company. */
    @Override
    public String toString() {
        return "Company: " + companyName + "\nOwner: " + super.toString();
    }
}
