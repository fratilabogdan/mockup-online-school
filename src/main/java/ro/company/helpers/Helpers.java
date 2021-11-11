package ro.company.helpers;

import java.time.LocalDateTime;

public class Helpers {

    public static String localDateSQLconvert(LocalDateTime localDateTime){
        return localDateTime.getYear()+"-"+localDateTime.getMonthValue()+"-"+localDateTime.getDayOfMonth()+" "+ localDateTime.getHour()+":"+localDateTime.getMinute()+":"+localDateTime.getSecond();
    }

}
