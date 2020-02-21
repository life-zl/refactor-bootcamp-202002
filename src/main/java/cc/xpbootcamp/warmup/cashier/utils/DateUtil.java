package cc.xpbootcamp.warmup.cashier.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String getWeekOfDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.CHINA);
        return sdf.format(new Date());
    }
}
