package fr.ekwateur.invoice.utils;

public enum PriceType {
    PRICE_PRI(0.121,0.115),
    PRICE_PRO_HIGH(0.114, 0.111),
    PRICE_PRO_LOW(0.118, 0.113);

    public final double electricityPrice;
    public final double gasPrice;

    PriceType(double electricityPrice, double gasPrice) {
        this.electricityPrice = electricityPrice;
        this.gasPrice = gasPrice;
    }

}
