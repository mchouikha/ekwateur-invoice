package fr.ekwateur.invoice.model;

public class Customer {

    public Customer(String reference) {
        this.reference = reference;
    }

    private final String reference;

    public String getReference() {
        return reference;
    }
}
