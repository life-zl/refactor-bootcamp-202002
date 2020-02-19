package cc.xpbootcamp.warmup.cashier.utils;

import cc.xpbootcamp.warmup.cashier.constants.FieldConstant;

import java.util.Calendar;

public class DateUtil {

    public static String getDateInfo() {
        Calendar now = Calendar.getInstance();
        return String.format(FieldConstant.DATE_PATTERN,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.DAY_OF_MONTH),
                getWeekOfDate(now));
    }

    public static String getWeekOfDate(Calendar date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = date.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
