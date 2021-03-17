package com.example.currenyexchangeservice;

import com.example.currenyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {

  ExchangeValue  findByFromAndTo(String from, String to);

}
