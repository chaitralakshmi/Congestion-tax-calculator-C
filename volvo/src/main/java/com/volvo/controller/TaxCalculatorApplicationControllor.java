package com.volvo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.volvo.core.CongestionTaxCalculator;
import com.volvo.model.TaxCalculatorRequest;
import com.volvo.cars.congestiontaxcalculator.model.TaxCalculatorResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
@Api(value = "Tax Calculator Service", description = "Service to calculate the tax in Gothenburg")
public class TaxCalculatorApplicationControllor {

    @Autowired
    CongestionTaxCalculator congestionTaxCalculator;

    @RequestMapping(value = "/calculatetax", method = RequestMethod.POST)
    @Operation(summary = "Calculate the tax", description = "This service for calculating the tax in Gothengurg city of Sweden")
    public ResponseEntity<TaxCalculatorResponse> taxCalculate(
            @ApiParam(value = "Request for Tax Calculation, Vehicle Type and list of dates and Date format is : yyyy-MM-dd HH:mm:ss", required = true) @RequestBody TaxCalculatorRequest request) {
        TaxCalculatorResponse response;
        try {
            int tax = congestionTaxCalculator.getTax(request.getVehicle_type(), request.getDates());

            response = new TaxCalculatorResponse(null, tax,
                    "Tax calculated successfully, Vehicle :" + request.getVehicle_type().name() + " Amount : " + tax);
            return new ResponseEntity<TaxCalculatorResponse>(response, HttpStatus.OK);
        } catch (Exception e) {
            response = new TaxCalculatorResponse(e.getLocalizedMessage(), 0,
                    "Tax calculation failed.");
            return new ResponseEntity<TaxCalculatorResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
