package com.myshop.online.service;

import com.myshop.online.dto.CustomerRegisterForm;
import com.myshop.online.dto.CustomerResponseDTO;
import com.myshop.online.exception.CustomerAlreadyRegisteredException;
import com.myshop.online.exception.CustomerNotFoundException;
import com.myshop.online.model.Customer;
import com.myshop.online.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    public CustomerResponseDTO register(CustomerRegisterForm form) {
        if (repository.existsByEmail(form.getEmail())) {
            throw new CustomerAlreadyRegisteredException();
        }

        var user = Customer.builder()
                .email(form.getEmail())
                .name(form.getName())
                .address(form.getAddress())
                .phoneNumber(form.getPhoneNumber())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return CustomerResponseDTO.from(user);
    }

    public CustomerResponseDTO getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(CustomerNotFoundException::new);

        return CustomerResponseDTO.from(user);
    }
}
