package com.example.demo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auth snifferhu
 * @date 2018/5/9 20:39
 */
public class StrToDateTest {

    @Test
    public void strToDateTest() throws ParseException {

        String strDate = "2018-05-09 21:48:54.123";
       Date date = strToDate(strDate);

        System.out.println(strDate);
       System.out.println(date);
    }

    private Date strToDate(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        Date ddate;
        ddate = sdf.parse(strDate);


        return ddate;


    }
}

