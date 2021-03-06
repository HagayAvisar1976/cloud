package com.example.limitsservice;

import com.example.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

  @Autowired
  Configuration configuration;

  @GetMapping("/limits")
  public LimitConfiguration reteriveLimitsFromConfiguration()
  {
    return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
  }
}
