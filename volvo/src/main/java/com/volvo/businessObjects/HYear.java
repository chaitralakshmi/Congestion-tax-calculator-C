package com.volvo.businessObjects;

import java.util.List;

import com.volvo.businessObjects.Hmonth;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class HYear {

    private int year;
    List<Hmonth> months;

}
