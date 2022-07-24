package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.Customer;
import com.example.onlineplantnursery.Entity.Plant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public Customer validateCustomer(Integer customerId, String username, String password, String customerName, String customerEmail);
    public Customer addCustomer(Customer customer);
    public Customer removeCustomer(Integer customerId);
    List<Customer> viewAllCustomers();
    Customer viewCustomer(Integer customerId);
}
