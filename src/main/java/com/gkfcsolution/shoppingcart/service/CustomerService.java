package com.gkfcsolution.shoppingcart.service;

import com.gkfcsolution.shoppingcart.entity.Customer;
import com.gkfcsolution.shoppingcart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created on 2025 at 11:49
 * File: null.java
 * Project: shoppingCart
 *
 * @author Frank GUEKENG
 * @date 26/09/2025
 * @time 11:49
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Integer isCustomerPresent(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(customer.getEmail());

        if (optionalCustomer.isPresent()){
            return optionalCustomer.get().getId();
        }
        return null;
    }
}
