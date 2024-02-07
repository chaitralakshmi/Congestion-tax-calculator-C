package com.volvo.businessObjects;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "tax-price")
@Getter
@Setter
public class TaxPrice {

    private List<CostTiming> timings;
}