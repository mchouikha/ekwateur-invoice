package fr.ekwateur.invoice.model;

public class ProfessionalCustomer extends Customer{

    public ProfessionalCustomer(String reference, String siret, String companyName, double turnover) {
        super(reference);
        this.siret = siret;
        this.companyName = companyName;
        this.turnover = turnover;
    }

    private String siret;
    private String companyName;
    private double turnover;

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }
}
