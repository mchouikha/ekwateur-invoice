package fr.ekwateur.invoice.model;

public class PrivateCustomer extends Customer {

    public PrivateCustomer(String reference, String firstName, String lastName, String civility) {
        super(reference);
        this.firstName = firstName;
        this.lastName = lastName;
        this.civility = civility;
    }

    private String firstName;
    private String lastName;
    private String civility;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }
}
