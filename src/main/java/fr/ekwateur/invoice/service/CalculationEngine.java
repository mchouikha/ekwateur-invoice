package fr.ekwateur.invoice.service;

import fr.ekwateur.invoice.utils.EnergyType;
import fr.ekwateur.invoice.utils.PriceType;
import fr.ekwateur.invoice.model.Customer;
import fr.ekwateur.invoice.model.PrivateCustomer;
import fr.ekwateur.invoice.model.ProfessionalCustomer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationEngine {

    public static final BigDecimal TURNOVER_LEVEL = new BigDecimal(1000000);

    private static  PriceType retrievePriceType(Customer customer){
        if(customer instanceof PrivateCustomer) {
            return PriceType.PRICE_PRI;
        } else if (customer instanceof ProfessionalCustomer proCustomer) {
            if( TURNOVER_LEVEL.compareTo(BigDecimal.valueOf(proCustomer.getTurnover())) >= 0 ){
                return PriceType.PRICE_PRO_LOW;
            } else {
                return PriceType.PRICE_PRO_HIGH;
            }
        } else {
            throw new RuntimeException("ERROR CANNOT DETECT PRICE_TYPE");
        }
    }

    public static BigDecimal calculateEnergyPrice(Customer customer, double quantity, EnergyType energyType){

        PriceType priceType = retrievePriceType(customer);
        BigDecimal price = null;
        switch (energyType){
            case GAS -> price = BigDecimal.valueOf(quantity).multiply(BigDecimal.valueOf(priceType.gasPrice)).setScale(3, RoundingMode.CEILING);
            case ELECTRICITY -> price = BigDecimal.valueOf(quantity).multiply(BigDecimal.valueOf(priceType.electricityPrice)).setScale(3, RoundingMode.CEILING);
            default -> System.out.println("Unknown Energy type " + energyType);
        }
        return price;
    }

}
