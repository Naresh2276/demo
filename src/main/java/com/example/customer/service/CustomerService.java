package com.example.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = repository.findById(id).orElse(null);

        if (existingCustomer == null) {
            return null;
        }

        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setCity(customer.getCity());

        return repository.save(existingCustomer);
    }

    public boolean deleteCustomer(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}