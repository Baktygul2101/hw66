package com.myshop.online.controller;



import com.myshop.online.model.Customer;
import com.myshop.online.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @PostMapping("/registration")
    public Customer createCustomer(@RequestParam("email") String email, @RequestParam("name") String name,
                                  @RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address, @RequestParam("login") String login, @RequestParam("password") String password) {
        Customer p = new Customer(email, name,address,phoneNumber, password);
        repo.save(p);
        return p;
    }

    @PostMapping("/login")
    public Customer makeLogin(@RequestParam("email") String email, @RequestParam("password") String password) {

        Customer p = repo.findByEmail(email).get();
        repo.save(p);
        return p;
    }



}
