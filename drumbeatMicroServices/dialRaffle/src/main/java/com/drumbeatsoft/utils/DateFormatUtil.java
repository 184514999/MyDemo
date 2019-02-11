package com.drumbeatsoft.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String dateToString(Date date){
        String s = sdf.format(date);
        return s;
    }
}
