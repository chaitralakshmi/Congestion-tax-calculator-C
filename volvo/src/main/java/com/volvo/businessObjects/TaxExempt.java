package com.volvo.businessObjects;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "tax-exempt")
@Getter
@Setter
public class TaxExempt {

    private Set<String> vehicles;

}
