package org.nicolasperussi.service;

import org.apache.commons.lang3.StringUtils;
import org.nicolasperussi.dao.CustomerDAO;
import org.nicolasperussi.domain.Customer;

import java.util.Locale;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = getCustomerDAO();
    }

    private CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            customerDAO = new CustomerDAO();
        }

        return customerDAO;
    }

    public void createCustomer(Customer customer) {

        System.out.println(StringUtils.capitalize(customer.getFirstName().toLowerCase(Locale.ROOT).trim()));
        customer.setFirstName(StringUtils.capitalize(customer.getFirstName().toLowerCase(Locale.ROOT).trim()));
        customer.setLastName(StringUtils.capitalize(customer.getLastName().toLowerCase(Locale.ROOT)));
        customer.setPhoneNumber(customer.getPhoneNumber().trim());

        customerDAO.save(customer);
    }

    public Customer findById(final int id) {
        return customerDAO.findById(id);
    }
}
