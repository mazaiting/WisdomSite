package com.mazaiting.site.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * Created by mazaiting on 18/4/2.
 */

public class DateUtil {
    /**
     * 将时间格式化为 "2018-04-02 20:09:34"形式
     *
     * @param currentTimeMillis 当前时间
     * @return 2018-04-02 形式的时间
     */
    public static String getTime(long currentTimeMillis) {
        Date date = new Date(currentTimeMillis);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    /**
     * 将时间格式化为 "2018-04-02 20:09"形式
     *
     * @param currentTimeMillis 当前时间
     * @return 2018-04-02 形式的时间
     */
    public static String getCurrentTime(long currentTimeMillis) {
        Date date = new Date(currentTimeMillis);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        return simpleDateFormat.format(date);
    }
}
