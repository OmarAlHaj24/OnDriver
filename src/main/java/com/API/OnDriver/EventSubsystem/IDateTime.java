package com.API.OnDriver.EventSubsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class IDateTime {
    private static IDateTime instance = null;

    private IDateTime() {
    }

    public static IDateTime getInstance() {
        if (instance == null) {
            instance = new IDateTime();
        }
        return instance;
    }

    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public boolean isWeekend(final Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return day == Calendar.SATURDAY || day == Calendar.SUNDAY;
    }
}
