package com.volvo;

import com.volvo.businessObjects.CostTiming;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CongestionTaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CongestionTaxApplication.class, args);

		CostTiming ct = new CostTiming();

		/*ct.setStartTime("07:00");
	    ct.setEndTime("08:00");
        ct.setPrice(8);

		System.out.println(ct.isTimeBetween("07:01"));*/
	}

}
