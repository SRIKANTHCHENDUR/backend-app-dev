package com.examly.springapp.service;

import com.examly.springapp.model.Customer;
import com.examly.springapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            customer.setId(id);
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }
    
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}