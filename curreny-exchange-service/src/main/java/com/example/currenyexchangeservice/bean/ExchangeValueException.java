package com.example.currenyexchangeservice.bean;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.NOT_FOUND, reason = "exchange value is not found")
public class ExchangeValueException extends RuntimeException{

}
