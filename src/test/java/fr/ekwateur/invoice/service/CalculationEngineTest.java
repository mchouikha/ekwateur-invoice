package fr.ekwateur.invoice.service;

import fr.ekwateur.invoice.model.Customer;
import fr.ekwateur.invoice.model.CustomerFactory;
import fr.ekwateur.invoice.utils.EnergyType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CalculationEngineTest {

    private static Customer privateCustomer;
    private static Customer professionalCustomerHigh;
    private static Customer professionalCustomerLow;

    @BeforeAll
    public static void init(){
        privateCustomer = CustomerFactory.createCustomer("PRI", "EKW12345678", "Teddy", "RINER", "M");
        professionalCustomerHigh = CustomerFactory.createCustomer("PRO", "EKW12345678", "siret", "MMC", "5000000");
        professionalCustomerLow = CustomerFactory.createCustomer("PRO", "EKW12345678", "siret", "MMC", "500000");
    }

    @Test
    public void shouldCalculateEnergyPricePrivateCustomer(){
        BigDecimal electricityPrice = CalculationEngine.calculateEnergyPrice(privateCustomer, 1, EnergyType.ELECTRICITY);
        BigDecimal gasPrice = CalculationEngine.calculateEnergyPrice(privateCustomer, 1, EnergyType.GAS);
        assertEquals(new BigDecimal("0.121"), electricityPrice);
        assertEquals(new BigDecimal("0.115"), gasPrice);
    }

    @Test
    public void shouldCalculateEnergyPriceProfessionalCustomerWhenLowTurnover(){
        BigDecimal electricityPrice = CalculationEngine.calculateEnergyPrice(professionalCustomerLow, 5, EnergyType.ELECTRICITY);
        BigDecimal gasPrice = CalculationEngine.calculateEnergyPrice(professionalCustomerLow, 5, EnergyType.GAS);
        assertEquals(new BigDecimal("0.590"), electricityPrice);
        assertEquals(new BigDecimal("0.565"), gasPrice);
    }

    @Test
    public void shouldCalculateEnergyPriceProfessionalCustomerWhenHighTurnover(){
        BigDecimal electricityPrice = CalculationEngine.calculateEnergyPrice(professionalCustomerHigh, 2.5, EnergyType.ELECTRICITY);
        BigDecimal gasPrice = CalculationEngine.calculateEnergyPrice(professionalCustomerHigh, 2.5, EnergyType.GAS);
        assertEquals(new BigDecimal("0.285"), electricityPrice);
        assertEquals(new BigDecimal("0.278"), gasPrice);
    }

}
