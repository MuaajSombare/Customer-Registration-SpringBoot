package com.muaaj_sombare_project.customer_project.controller;

import com.muaaj_sombare_project.customer_project.entity.Customer;
import com.muaaj_sombare_project.customer_project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

@RequestMapping(value = "/hello", method = RequestMethod.GET)
public String returningWelcome(){
    return "hello world";
}



@PostMapping("/customer")
public Customer saveCustomer(@RequestBody Customer customer) {

return customerService.saveCustomer(customer);

}
@GetMapping("/customer")
public List<Customer> getCustomer(){
    return customerService.getCustomer();
}
@GetMapping("/customer/{name}")
public ResponseEntity<?> getCustomerByName(@PathVariable("name") String customerName){

    Customer c = customerService.getCustomerByName(customerName);
    if(c == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
    else return ResponseEntity.ok(c);
}
@DeleteMapping("/customer/{id}")
public  String deleteCustomerById(@PathVariable("id") Long customerId){
    return customerService.deleteCustomerById(customerId);

//    if( == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
//    else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("deleted successfully....");

}

@PutMapping("/customer/{id}")
public Customer updateCustomerById(@PathVariable("id") Long customerId,
                                   @RequestBody Customer customer){
return customerService.updateCustomerById(customerId,customer);
}



}
