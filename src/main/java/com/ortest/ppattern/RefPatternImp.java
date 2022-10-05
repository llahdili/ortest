package com.ortest.ppattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class RefPatternImp implements OrderPattern {

    @Override
    public String referencePatt(Date date) {
        if (date.getDay() == 1) {
            return "BC" + date.getMonth()+"-"+date.getDay() + 1;
        } else {
            return "BC" + date.getMonth()+"-"+date.getDay();
        }


    }
}