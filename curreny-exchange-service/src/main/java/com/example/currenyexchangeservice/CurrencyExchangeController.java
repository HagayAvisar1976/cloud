package com.example.currenyexchangeservice;

import com.example.currenyexchangeservice.bean.ExchangeValue;
import com.example.currenyexchangeservice.bean.ExchangeValueException;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeValueRepository repository;

  @GetMapping("/currency-exchange/{from}/to/{to}")
  public ExchangeValue reteriveExchangeValue(@PathVariable String from, @PathVariable String to){

    ExchangeValue exchangeValue = repository.findByFromAndTo(from,to); //new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
    if(exchangeValue==null){
      throw new ExchangeValueException();
    }
    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
    return exchangeValue;
  }

}
