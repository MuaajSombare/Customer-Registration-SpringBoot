package com.muaaj_sombare_project.customer_project.service;

import com.muaaj_sombare_project.customer_project.entity.Customer;
import com.muaaj_sombare_project.customer_project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }

    @Override
    public String deleteCustomerById(Long customerId) {
        List<Customer> cu = customerRepository.findAll();
        ArrayList a1 = new ArrayList();
        Iterator i = cu.iterator();
        while (i.hasNext()){
            Customer cu1 = (Customer)i.next();
            a1.add(cu1.getCustomerId());
        }
        if(a1.contains(customerId)){
            customerRepository.deleteById(customerId);
            return "deleted successfully...";
        }
        else
            return "not found";
    }

    @Override
    public Customer updateCustomerById(Long customerId, Customer customer) {
        Customer cu = customerRepository.findById(customerId).get();
        if(cu!=null){
            cu = new Customer();
        }

        if(Objects.nonNull(customer.getCustomerName()) && !"".equalsIgnoreCase(customer.getCustomerName())){
            cu.setCustomerName(customer.getCustomerName());
        }
        if(Objects.nonNull(customer.getCustomerAddress()) && !"".equalsIgnoreCase(customer.getCustomerAddress())){
            cu.setCustomerAddress(customer.getCustomerAddress());
        }
        return customerRepository.save(cu);
    }


}
