package com.accounting.currencies.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
    public static String today(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return dateString;
    }
    public static String yesterday(){
        Date date = new Date(System.currentTimeMillis()-24*60*60*1000);
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return dateString;
    }

}
