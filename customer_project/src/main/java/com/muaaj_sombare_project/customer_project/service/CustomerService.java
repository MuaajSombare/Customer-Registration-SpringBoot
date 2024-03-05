package com.muaaj_sombare_project.customer_project.service;

import com.muaaj_sombare_project.customer_project.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> getCustomer();

    Customer getCustomerByName(String customerName);

    String deleteCustomerById(Long customerId);

    Customer updateCustomerById(Long customerId, Customer customer);


//    Customer getCustomerByName(String customerName);
//    Customer findByName(String customerName);
}
