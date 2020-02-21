package cc.xpbootcamp.warmup.cashier.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static cc.xpbootcamp.warmup.cashier.constants.FieldConstant.WEEK_PATTERN;

public class DateUtil {

    public static String getWeekOfDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(WEEK_PATTERN, Locale.CHINA);
        return sdf.format(new Date());
    }
}
