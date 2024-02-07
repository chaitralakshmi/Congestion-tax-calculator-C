package com.volvo.businessObjects;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Hmonth {

    private int month;
    List<Integer> dates;
}
