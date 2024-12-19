package org.nicolasperussi;

import org.nicolasperussi.domain.Customer;
import org.nicolasperussi.domain.Vehicle;
import org.nicolasperussi.service.CustomerService;
import org.nicolasperussi.service.VehicleService;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        customerService.createCustomer(new Customer("   NicoLAu    ", "PeRussi    ", "999888777"));
    }
}
