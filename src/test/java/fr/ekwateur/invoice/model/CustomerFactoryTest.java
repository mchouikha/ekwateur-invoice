package fr.ekwateur.invoice.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerFactoryTest {

    @Test
    public void shouldReturnPrivateCustomer(){
        Customer customer = CustomerFactory.createCustomer("PRI", "EKW12345678", "Teddy", "RINER", "M");
        assertEquals("EKW12345678", customer.getReference());
        assertInstanceOf(PrivateCustomer.class, customer);
    }

    @Test
    public void shouldReturnProfessionalCustomer(){
        Customer customer = CustomerFactory.createCustomer("PRO", "EKW12345678", "siret", "MMC", "5000000");
        assertEquals("EKW12345678", customer.getReference());
        assertInstanceOf(ProfessionalCustomer.class, customer);
        assertEquals(Double.parseDouble("5000000"), ((ProfessionalCustomer)customer).getTurnover());
    }

    @Test
    public void shouldReturnException(){
        assertThrows(RuntimeException.class, () -> CustomerFactory.createCustomer("PRA", "EKW12345678", "Teddy", "RINER", "5000000"));
    }
}
