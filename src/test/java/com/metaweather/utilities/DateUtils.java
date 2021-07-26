package com.metaweather.utilities;

import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public String processDate(String date) {

        Calendar cal = Calendar.getInstance();

        switch (date.toLowerCase()) {
            case "yesterday":
                cal.add(Calendar.DATE, -1);
                break;
            case "today":

                break;
            case "tomorrow":
                cal.add(Calendar.DATE, 1);
                break;
            default:
                return date;
        }
        return "" + cal.get(Calendar.YEAR) + '/' + cal.get(Calendar.MONTH) + '/' + cal.get(Calendar.DAY_OF_MONTH);
    }


    public String swapDateFormat(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date ReqDay = sdf.parse(date.replace('/','-'));
            return sdf.format(ReqDay);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
