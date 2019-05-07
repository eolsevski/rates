package com.accounting.currencies.Services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
    public static String today(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return dateString;
    }
}
