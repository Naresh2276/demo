package com.example.customer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.customer.entity.CustomerEntity;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // CREATEg
    @PostMapping
    public CustomerEntity createCustomer(@RequestBody CustomerEntity customer) {
        return service.createCustomer(customer);
    }

    // READ ALL
    @GetMapping
    public List<CustomerEntity> getAllCustomers() {
        return service.getAllCustomers();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable Long id) {

        CustomerEntity customer = service.getCustomerById(id);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerEntity customer) {

        CustomerEntity updatedCustomer = service.updateCustomer(id, customer);

        if (updatedCustomer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedCustomer);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {

        boolean deleted = service.deleteCustomer(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Customer deleted successfully");
    }
}
