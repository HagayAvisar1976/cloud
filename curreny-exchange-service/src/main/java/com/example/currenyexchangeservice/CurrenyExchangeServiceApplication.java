package com.example.currenyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrenyExchangeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CurrenyExchangeServiceApplication.class, args);
  }
}
