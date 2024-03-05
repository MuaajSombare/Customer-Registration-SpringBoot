package com.muaaj_sombare_project.customer_project.repository;

import com.muaaj_sombare_project.customer_project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByCustomerName(String customerName);

//    Customer findAllById(Long customerId);
}
