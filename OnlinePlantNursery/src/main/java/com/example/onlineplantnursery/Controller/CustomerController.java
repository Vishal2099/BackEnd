package com.example.onlineplantnursery.Controller;


import com.example.onlineplantnursery.Entity.Customer;
import com.example.onlineplantnursery.Entity.Plant;
import com.example.onlineplantnursery.Service.CustomerService;
import com.example.onlineplantnursery.Service.CustomerServiceImplement;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:3000")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/welcome")
    public String customer() {
        return("<h1>Welcome to Online Nursery</h1>");
    }

    @ApiOperation("Add New Customer")
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer customerNew=customerService.addCustomer(customer);
        log.info("Added new Customer");
        return new ResponseEntity<>(customerNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> validateCustomer(@RequestParam Integer customerId, String username, String password, String customerName, String customerEmail) {
        Customer customer=customerService.validateCustomer(customerId,username,password, customerName,customerEmail);
        if(customer!=null) {
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>(customer, HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Customer> removeCustomer(@RequestBody Integer customerId) {
        Customer customerRemoved=customerService.removeCustomer(customerId);
        if(customerRemoved!=null)
            return new ResponseEntity<>(customerRemoved, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(customerRemoved, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/viewall")
    public List<Customer> viewAllCustomers(){
        return customerService.viewAllCustomers();
    }

    @GetMapping("/view")
    public ResponseEntity<Customer> viewPlant(@RequestParam Integer customerId){
        Customer customer = customerService.viewCustomer(customerId);
        return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
    }
}
