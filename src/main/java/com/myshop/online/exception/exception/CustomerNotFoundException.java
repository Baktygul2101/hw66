package com.myshop.online.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Customer Not Found") //404
public class CustomerNotFoundException extends Exception {


    @NotBlank
    @Email
    private  String email = "";
    public CustomerNotFoundException(String email){
        super("CustomerNotFoundException with email="+email);
    }
}