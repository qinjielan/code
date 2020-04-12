package com.qjl.lambdatest.date;


import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {

    @Test
    public void test01(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDateTime time = LocalDateTime.now();
        String format = dtf.format(time);
        System.out.println(format);
    }
}
