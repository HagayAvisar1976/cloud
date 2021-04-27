package com.example.currencyconversionservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url ="localhost:8000" )
//@FeignClient(name = "currency-exchange-service") // move it to configuration in order to talk with all instanaces
//@RibbonClient(name = "currency-exchange-service")
public interface CurrenyExchangeServiceProxy {

  @GetMapping("/currency-exchange/{from}/to/{to}")
  public CurrencyConversionBean reteriveExchangeValue(@PathVariable String from, @PathVariable String to);

}
