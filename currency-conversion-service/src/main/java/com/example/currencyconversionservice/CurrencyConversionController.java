package com.example.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

  @Autowired
  private CurrenyExchangeServiceProxy proxy;

  @GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

    // Feign - simplfy the call for other services.
    Map<String,String> uriVariables = new HashMap<>();
    uriVariables.put("from",from);
    uriVariables.put("to",to);

    ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate()
        .getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

    CurrencyConversionBean body = responseEntity.getBody();

    return new CurrencyConversionBean(body.getId(),from,to,body.getConversionMultiple(),quantity,
        quantity.multiply(body.getConversionMultiple()),body.getPort());
  }

  //another way to call another service using Feign.
  @GetMapping("/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

    CurrencyConversionBean body = proxy.reteriveExchangeValue(from,to);

    return new CurrencyConversionBean(body.getId(),from,to,body.getConversionMultiple(),quantity,
        quantity.multiply(body.getConversionMultiple()),body.getPort());
  }


}
