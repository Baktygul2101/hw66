package com.myshop.online.repository;

import com.myshop.online.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    boolean existsByEmail(String email);
    Optional<Customer> findByEmail(String email);
}