package fr.ekwateur;

import fr.ekwateur.invoice.model.Customer;
import fr.ekwateur.invoice.model.CustomerFactory;
import fr.ekwateur.invoice.service.CalculationEngine;
import fr.ekwateur.invoice.utils.EnergyType;

import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {

        if(args.length < 7){
            throw new RuntimeException("This program need 7 args input | sample: PRI EKW12345678 PAUL TOTO M 2 3");
        }

        //Sample args private customer : PRI EKW12345678 PAUL TOTO M 2 3
        //Sample args professional customer : PRO EKW87654321 siret MMC 500000 2 3
        Customer customer = CustomerFactory.createCustomer(args[0], args[1], args[2], args[3], args[4]);
        BigDecimal electricityPrice = CalculationEngine.calculateEnergyPrice(customer, Double.parseDouble(args[5]), EnergyType.ELECTRICITY);
        BigDecimal gasPrice = CalculationEngine.calculateEnergyPrice(customer, Double.parseDouble(args[6]), EnergyType.GAS);
        System.out.println("Electricity Price :" + electricityPrice + "€");
        System.out.println("Gas Price :" + gasPrice + "€");
        System.out.println("Total :"+ electricityPrice.add(gasPrice)+ "€");
    }
}