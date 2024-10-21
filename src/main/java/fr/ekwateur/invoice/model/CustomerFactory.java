package fr.ekwateur.invoice.model;

import java.util.regex.Pattern;

public class CustomerFactory {

    private static final String CUSTOMER_TYPE_PRI = "PRI";
    private static final String CUSTOMER_TYPE_PRO = "PRO";
    private static final Pattern PATTERN_REFERENCE = Pattern.compile("^(EKW)[1-9]{8}");

    public static Customer createCustomer(String customerType, String reference, String element1, String element2, String element3){
        if(!PATTERN_REFERENCE.matcher(reference).matches()){
            throw new RuntimeException("ERROR reference format is not correct ");
        }
        switch (customerType){
            case CUSTOMER_TYPE_PRI -> {
                return new PrivateCustomer(reference, element1, element2, element3);
            }
            case CUSTOMER_TYPE_PRO -> {
                double turnover = Double.parseDouble(element3);
                return new ProfessionalCustomer(reference, element1, element2, turnover);
            }
            default -> throw new RuntimeException("Error : UNABLE TO DETECT CUSTOMER WITH TYPE" + customerType);
        }
    }
}
