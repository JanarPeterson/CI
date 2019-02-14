package com.customer.infosystem.CI.service;

import com.customer.infosystem.CI.entity.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    List<Customer> getCustomers();
    Optional<Customer> getCustomerById(int id);
    Customer saveCustomer(Customer customer);
    boolean deleteCustomer(int id);
}
