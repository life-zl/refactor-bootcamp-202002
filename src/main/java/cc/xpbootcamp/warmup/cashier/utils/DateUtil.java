package cc.xpbootcamp.warmup.cashier.utils;

import cc.xpbootcamp.warmup.cashier.constants.FieldConstant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String getDateInfo() {
        Calendar now = Calendar.getInstance();
        return String.format(FieldConstant.DATE_PATTERN,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH) + 1,
                now.get(Calendar.DAY_OF_MONTH),
                getWeekOfDate());
    }

    public static String getWeekOfDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.CHINA);
        return sdf.format(new Date());
    }
}
