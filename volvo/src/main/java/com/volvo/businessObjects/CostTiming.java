package com.volvo.businessObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class CostTiming {

    private String startTime;

    private String endTime;
    private int price;

    final SimpleDateFormat sd = new SimpleDateFormat("HH:mm");

    public boolean isTimeBetween(String someRandomTime) {
        try {
            Date time1 = this.sd.parse(this.startTime);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, 1);

            Date time2 = this.sd.parse(this.endTime);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);

            Date d = this.sd.parse(someRandomTime);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);

            Date x = calendar3.getTime();
            if ((x.after(calendar1.getTime()) || x.equals(calendar1.getTime())) && (x.before(calendar2.getTime())) || x.equals(calendar2.getTime())) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

}
