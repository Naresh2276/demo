package com.example.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customer.entity.CustomerEntity;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerEntity createCustomer(CustomerEntity customer) {
        return repository.save(customer);
    }

    public List<CustomerEntity> getAllCustomers() {
        return repository.findAll();
    }

    public CustomerEntity getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public CustomerEntity updateCustomer(Long id, CustomerEntity customer) {

        CustomerEntity existingCustomer = repository.findById(id).orElse(null);

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