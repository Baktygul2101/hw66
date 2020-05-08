package com.myshop.online.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Customer Not Found") //404
public class CustomerNotFoundException extends RuntimeException {


}