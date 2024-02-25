package com.ruoyi.stock.utils;


import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public class DateUtils {
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间格式(yyyyMMdd)
     */
    public final static String DATEPATTERN = "yyyyMMdd";

    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static Integer formatTime(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return Integer.valueOf(df.format(date));
        }
        return null;
    }

    /**
     * 周末返回false
     *
     * @return 周末返回false
     */
    public static boolean thisDayOfWeek() {
        int day = DateUtil.thisDayOfWeek();
        if (1 == day || 7 == day)
            return false;
        return true;
    }
}
