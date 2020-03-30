package com.yinft.easydate.util;


import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yinft
 * Date: 20-3-25
 * Time: 下午17:08
 */
public class DateUtils {

    /**
     * 年份
     */
    public static final String DATE_FORMAT_YEAR_EN = "yyyy";

    /**
     * 年月 2015-10
     */
    public static final String DATE_FORMAT_YM_EN = "yyyy-MM";

    /**
     * 年月日,如：2015-10-28
     */
    public static final String DATE_FORMAT_STANDARD_EN = "yyyy-MM-dd";

    /**
     * 默认时间格式, yyyy-MM-dd hh24
     */
    public static String DATE_FORMAT_YMD_H = "yyyy-MM-dd HH";

    /**
     * 时间格式, yyyy-MM-dd hh24:mm 如：2015-07-26 10:10
     */
    public static String DATE_FORMAT_YMD_HM = "yyyy-MM-dd HH:mm";

    /**
     * 时间格式, yyyy-MM-dd hh24:mm:ss 如：2015-10-28 16:10:02
     */
    public static String DATE_FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";

    /**
     *
     */
    public static String DATE_FORMAT_FULL_EN = "yyyy-MM-dd HH:mm:ss.S";

    /**
     *
     */
    public static final String DATE_FORMAT_YMD_SHORT_EN = "yyyyMMdd";

    /**
     *
     */
    public static final String DATE_FORMAT_EN_ = "yyyyMMddhhmmss";

    /**
     *
     */
    public static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 年份，如2015年
     */
    public static final String DATE_FORMAT_YEAR_CN = "yyyy年";

    /**
     * 中文年月格式，如2015年12月
     */
    public static final String DATE_FORMAT_YM_CN = "yyyy年MM月";

    /**
     * 文日期格式，如2015年12月05日
     */
    public static final String DATE_FORMAT_STANDARD_CN = "yyyy年MM月dd日";

    /**
     *
     */
    public static final String DATE_FORMAT_FULL_CN = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";

    /**
     * 一秒的毫秒数,1000毫秒
     */
    public static final long MILLIS_PER_SECOND = 1000;

    /**
     * 一分钟的毫秒数,60*1000毫秒
     */
    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;

    /**
     * 一小时的毫秒数,60*60*1000
     */
    public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

    /**
     * 一天的毫秒数,24*60*60*1000
     */
    public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    /**
     * 普通年 二月的天数，28天
     */
    public static final Integer COMMON_YEAR_FEBRUARY_DAYS = 28;

    /**
     * 闰年的二月的天数，29天
     */
    public static final Integer LEAP_YEAR_FEBRUARY_DAYS = 29;


    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 时间字符串(yyyy-MM-dd HH:mm:ss)转Date
     */
    public static Date str2Date(String dateStr) {
        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf = null;
        Date date = null;
        sdf = new SimpleDateFormat(DATE_FORMAT_STANDARD);
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static Date str2Date(String dateStr, String format) {
        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf = null;
        Date date = null;
        if (!StringUtils.hasText(format)) {
            sdf = new SimpleDateFormat(DATE_FORMAT_STANDARD);
        } else {
            sdf = new SimpleDateFormat(format);
        }
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * [简要描述]:判断是否是日期格式
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static boolean isDate(String dateStr, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            formatter.parse(dateStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DATE_FORMAT_STANDARD);
    }

    /**
     * [简要描述]:获取日期格式
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date parseDate(String dateStr, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    public static Timestamp getTimesStamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * [简要描述]:获取日期格式
     *
     * @return
     */
    public static String getTimestampString() {
        return date2Str(new Date(), DATE_FORMAT_EN_);
    }

    /**
     * [简述]:获取 日期时间 时分秒
     *
     * @param date 日期
     * @return HH:mm:ss
     */
    public static String getTime(String date) {
        return date2Str(str2Date(date), HH_MM_SS);
    }

    /**
     * [简述]:获取 日期时间 时分秒
     *
     * @param date 日期
     * @return HH:mm:ss
     */
    public static String getTime(Date date) {
        return date2Str(date, HH_MM_SS);
    }


    /**
     * [简述]:日期增加年
     *
     * @param date       日期
     * @param yearAmount 增加的年 ，可以为负数
     * @return
     */
    public static Date addYear(Date date, int yearAmount) {
        return add(date, Calendar.YEAR, yearAmount);
    }

    /**
     * [简述]:日期增加年
     *
     * @param date       日期
     * @param yearAmount 增加的年 ，可以为负数
     * @return
     */
    public static String addYear(String date, int yearAmount) {
        return add(date, Calendar.YEAR, yearAmount);
    }


    /**
     * [简述]:日期增加月数
     *
     * @param date        日期
     * @param monthAmount 增加的月数 ，可以为负数
     * @return
     */
    public static Date addMonth(Date date, int monthAmount) {
        return add(date, Calendar.MONTH, monthAmount);
    }

    /**
     * [简述]:日期增加月数
     *
     * @param date        日期
     * @param monthAmount 增加的月数 ，可以为负数
     * @return
     */
    public static String addMonth(String date, int monthAmount, String format) {
        //return add(date, Calendar.MONTH, monthAmount);
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Date _date = str2Date(date, format);
        return date2Str(add(_date, Calendar.MONTH, monthAmount), format);
    }

    /**
     * [简述]:日期增加星期数
     *
     * @param date       日期
     * @param weekAmount 增加的星期数 ，可以为负数
     * @return
     */
    public static Date addWeek(Date date, int weekAmount) {
        return add(date, Calendar.WEEK_OF_YEAR, weekAmount);
    }

    /**
     * [简述]:日期增加星期数
     *
     * @param date       日期
     * @param weekAmount 增加的星期数 ，可以为负数
     * @return
     */
    public static String addWeek(String date, int weekAmount) {
        return add(date, Calendar.WEEK_OF_YEAR, weekAmount);
    }

    /**
     * [简述]:日期增加天数
     *
     * @param date      日期
     * @param dayAmount 增加的天数
     * @return
     */
    public static Date addDay(Date date, int dayAmount) {
        return add(date, Calendar.DAY_OF_MONTH, dayAmount);
    }

    /**
     * [简述]:日期增加分钟
     *
     * @param date         日期
     * @param minuteAmount 增加的分钟数，可以为负数
     * @return date
     */
    public static Date addMinute(Date date, int minuteAmount) {
        return add(date, Calendar.MINUTE, minuteAmount);
    }

    /**
     * [简述]:日期增加分钟
     *
     * @param date         日期
     * @param minuteAmount 增加的分钟数，可以为负数
     * @return String
     */
    public static String addMinute(String date, int minuteAmount) {
        return add(date, Calendar.MINUTE, minuteAmount);
    }


    /**
     * [简述]:日期增加秒
     *
     * @param date         日期
     * @param secondAmount 增加的秒数，可以为负数
     * @return
     */
    public static Date addSecond(Date date, int secondAmount) {
        return add(date, Calendar.SECOND, secondAmount);
    }

    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static String add(String date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Date _date = str2Date(date);
        return date2Str(add(_date, calendarField, amount));
    }

    /**
     * [简述]:获取年份
     *
     * @param date 日期
     * @return yyyy, 如2015
     */
    public static String getYear(Date date) {
        return date2Str(date, DATE_FORMAT_YEAR_EN);
    }

    public static String getYear(String date) {
        return add(date, Calendar.YEAR, 0);
    }


    /**
     * [简述]:获取年份
     *
     * @param date      日期
     * @param formatter ，如 yyyy 或者 yyyy年
     * @return 2016或者2016年
     */
    public static String getYear(Date date, String formatter) {
        String year = "";
        if (DATE_FORMAT_YEAR_EN.equalsIgnoreCase(formatter)) {
            year = date2Str(date, DATE_FORMAT_YEAR_EN);
        } else if (DATE_FORMAT_YEAR_CN.equalsIgnoreCase(formatter)) {
            year = date2Str(date, DATE_FORMAT_YEAR_EN);
        }
        return year;
    }

    /**
     * [简述]:将时间 转化为毫秒数
     *
     * @param date
     * @return
     */
    public static Long dateToMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * [简要描述]:格式化日期类型，返回String
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter = null;
        if (StringUtils.hasText(format)) {
            formatter = new SimpleDateFormat(format);
        }

        String dateStr = null;
        try {
            dateStr = formatter.format(date);
        } catch (Exception e) {
            return null;
        }
        return dateStr;
    }


    public static String date2Str(Date date) {
        return date2Str(date, DATE_FORMAT_STANDARD);
    }


    /**
     * [简要描述]:得到当日在当前月份的星期数
     *
     * @param date
     * @return
     */
    public static int getWeekOfMonth(Date date) {
        Calendar timeDate = Calendar.getInstance();
        timeDate.setTime(date);
        return timeDate.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * [简述]:获取当前系统时间
     *
     * @return date
     */
    public static Date getCurrSysDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * [简述]:获取当前系统时间
     *
     * @return
     */
    public static String getCurrSysDateStr() {
        Calendar calendar = Calendar.getInstance();
        return date2Str(calendar.getTime());
    }

    public static Date long2Date(long millisecond) {
        return new Date(millisecond);
    }

    /**
     * 获取定时时间 每小时5分钟 的毫秒数
     *
     * @return
     */
    public static Long getScheduledCronTime(Date curDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static String strDateFormatByType(String dateStr, String type) {
        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        String sDate = "";
        try {
            Date date = sdf1.parse(dateStr);
            SimpleDateFormat sdf = new SimpleDateFormat(type);
            sDate = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sDate;
    }

    /**
     * 获取当前时间年的第一天,格式：yyyy-MM-dd
     *
     * @return
     */
    public static Date getFirstDayOfThisYear(Date date, Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + year);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取时间的后几年
     * param:time 时间；num 几年，可正可负
     * return:long形的时间
     */
    public static Long getLastXYear(Long time, int num) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(time);
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, num);
        return calendar.getTime().getTime();
    }

    public static int getDaysCurrentYearMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        System.out.println("aaa:" + calendar.get(Calendar.MONTH));
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前系统时间当前月的第一天,格式：yyyy-MM-dd
     *
     * @return
     */
    public static Date getFirstDayOfCurrentDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static String getFirstDayOfCurrentMonth(){
        return date2Str(getFirstDayOfCurrentDate(new Date()),DATE_FORMAT_STANDARD_EN);
    }




    public static Date getDateOfLastYear(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(date2Str(calendar.getTime(), DATE_FORMAT_STANDARD));
        return calendar.getTime();
    }


    public static boolean isFirstDayZeroClockOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (0 == calendar.get(Calendar.MONTH) && 1 == calendar.get(Calendar.DAY_OF_MONTH) && isZeroClockOfDay(date)) ? true : false;
    }

    /**
     * 判断 该日期是否是月初一号 凌晨 1点之前的时间
     *
     * @return
     */
    public static boolean isFirstDayZeroClockOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (1 == calendar.get(Calendar.DAY_OF_MONTH) && isZeroClockOfDay(date)) ? true : false;
    }

    public static boolean isZeroClockOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour == 0 ? true : false;

    }

    private static Date addOneHourOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        return calendar.getTime();
    }

    public static Date subOneDayOfCurrentDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date subOneDayOfCurrentDate(Date date, int dayNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dayNum);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR));
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前系统时间上一个月的第一天,格式：yyyy-MM-dd
     *
     * @return
     */
    public static Date getFirstDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    //获取上个月的第一天:yyyy-MM-dd
    public static String getLastMonthFirstDay(){
        return date2Str(getFirstDayOfLastMonth(new Date()),DATE_FORMAT_STANDARD_EN);
    }




    /**
     * 上个月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * [简述]:该日期的最后一天
     *
     * @param date yyyy-MM-dd
     * @return
     */
    public static String getLastDayOfMonth(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(str2Date(date, DATE_FORMAT_YM_EN));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), DATE_FORMAT_STANDARD_EN);
    }

    /**
     * 获取上个月同一天
     */
    public static String getDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), DATE_FORMAT_STANDARD_EN);
    }

    public static String getDayOfLastMonth(Date date, String formatter) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), formatter);
    }

    /**
     * 获取下个月同一天
     */
    public static String getDayOfNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), DATE_FORMAT_STANDARD_EN);
    }

    public static String getDayOfNextMonth(Date date, String formatter) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), formatter);
    }

    /*public static Date getSamePeriodTime(Date date) {
        Date result = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int maxDaysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        if (currentDay == maxDaysOfMonth) {
            result = getLastDayOfLastMonth(date);
        } else if ((calendar.get(Calendar.MONTH) + 1) == 3) {
            int year = calendar.get(Calendar.YEAR);
            if (isLeapYear(year)) {
                if (currentDay >= LEAP_YEAR_FEBRUARY_DAYS) {
                    result = getLastDayOfLastMonth(date);
                } else {
                    result = getDayOfLastMonth(date);
                }
            } else {
                if (currentDay >= COMMON_YEAR_FEBRUARY_DAYS) {
                    result = getLastDayOfLastMonth(date);
                } else {
                    result = getDayOfLastMonth(date);
                }
            }
        } else {
            result = getDayOfLastMonth(date);
        }
        return result;
    }*/

    /**
     * 判断是否是闰年
     *
     * @param year
     * @return boolean{true,false}
     */
    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true : false;
    }


    public static Date getLastHourTimeOfCurrentDate(Date curDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(calendar.HOUR_OF_DAY) - 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Long getZeroClockOfCurrentDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return dateToMillis(calendar.getTime());
    }

    public static long getSharkClockOfCurrentDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(DateUtils.date2Str(calendar.getTime(), DATE_FORMAT_STANDARD));
        return dateToMillis(calendar.getTime());
    }

    public static Long getLastDayTimeOfCurrentDate(long dateMillis) {
        return dateMillis - MILLIS_PER_DAY;
    }


    public static Long getLastHourTime(Date curDate) {
        return dateToMillis(getLastHourTimeOfCurrentDate(curDate));
    }

    public static Long getLastDayOfCurrentDate(Date date) {
        return dateToMillis(subOneDayOfCurrentDate(date));
    }

    public static Long getLastSomeDayOfCurrentDate(Date date, int dayNum) {
        return dateToMillis(subOneDayOfCurrentDate(date, dayNum));
    }

    public static Long getFirstDayOfLastMonthOfCurrentDate(Date date) {
        return dateToMillis(getFirstDayOfLastMonth(date));
    }

    public static Long getFirstDayZeroClockOfCurrentDate(Date date) {
        return dateToMillis(getFirstDayOfCurrentDate(date));
    }

    public static Long getFirstDayOfThisYearOfCurrentDate(Date date, Integer year) {
        return dateToMillis(getFirstDayOfThisYear(date, year));
    }


    public static long getDaysBetweenTwoDate(String date1, String date2) {
        long days = 0;
        long time1 = dateToMillis(parseDate(date1, DATE_FORMAT_STANDARD));
        long time2 = dateToMillis(parseDate(date2, DATE_FORMAT_STANDARD));
        long diff = Math.abs(time1 - time2);
        return diff / MILLIS_PER_DAY;
    }

    public static long getHoursBetweenTwoDate(String date1, String date2) {
        long time1 = dateToMillis(parseDate(date1, DATE_FORMAT_STANDARD));
        long time2 = dateToMillis(parseDate(date2, DATE_FORMAT_STANDARD));
        long diff = Math.abs(time1 - time2);
        return diff / MILLIS_PER_HOUR;
    }

    public static void main(String args[]) {
        //System.out.println(1>=2);
        //System.out.println(Integer.parseInt(""));
        Integer a = 1;
        Integer b = 1;

        System.out.println((char) (64 + 1) + "");
    }

    public static String convertStringToHex(String str, int byteLength) {

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        int sbuLength = hex.length();
        for (int i = 0; i < byteLength - sbuLength; i++) {
            hex.append("0");
        }
        return hex.toString();
    }

    public String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }

    /**
     * Fri May 01 00:00:00 CST 2015 转换为2015-05-01
     *
     * @param dateStr
     * @return
     */
    public static String strDateFormat(String dateStr) {
        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        String sDate = "";
        try {
            Date date = sdf1.parse(dateStr);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sDate = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sDate;
    }

    /**
     * 将字符串日期转换为 特定的格式
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static String formatDateStr(String dateStr, String format) {
        if (null == dateStr || "".equals(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT_STANDARD_EN);
        String sDate = "";
        try {
            Date date = sdf1.parse(dateStr);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sDate = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sDate;
    }

    /**
     * 获取当前系统时间 特定的格式
     *
     * @param format
     * @return
     */
    public static String sysDateOfFormat(String format) {
        Date date = new Date();
        SimpleDateFormat formatter = null;
        if (StringUtils.hasText(format)) {
            formatter = new SimpleDateFormat(format);
        }

        String dateStr = null;
        try {
            dateStr = formatter.format(date);
        } catch (Exception e) {
            return null;
        }
        return dateStr;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDateStr
     * @param endDateStr
     * @return List
     */
    public static List<String> getDatesBetweenTwoDate(String beginDateStr, String endDateStr) {
        List<String> resultList = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = sdf.parse(beginDateStr);
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resultList.add(beginDateStr); // 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                resultList.add(DateUtils.date2Str(cal.getTime(), DATE_FORMAT_STANDARD_EN));
            } else {
                break;
            }
        }
        resultList.add(endDateStr);// 把结束时间加入集合
        return resultList;
    }

    /**
     * 获取多少天后的时间
     *
     * @param dateStr
     * @param num
     * @return
     */
    public static String getBeforeDayOfStandFormat(String dateStr, int num, String format) {
        Date currentDate = str2Date(dateStr, format);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1 * num);
        Date result = calendar.getTime();
        return date2Str(result, format);
    }

    /**
     * 获取系统时间多少天前的时间
     *
     * @param dateStr
     * @param num
     * @return
     */
    public static Date getBeforeDayOfStandFormat(Date dateStr, int num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateStr);
        calendar.add(Calendar.DAY_OF_MONTH, -1 * num);
        return calendar.getTime();

    }

    /**
     * 获取当前系统时间
     *
     * @return
     */
    public static String getCurrentDate(String format) {
        Calendar calendar = Calendar.getInstance();
        String currentDay = new SimpleDateFormat(format).format(calendar.getTime());
        return currentDay;
    }

    /**
     * 获取指定日期的前后几天
     *
     * @param date
     * @param num
     * @return yyyy-MM-dd
     */
    public static String getDayAfter(Date date, int num) {
        Date date1 = getBeforeDayOfStandFormat(date, num);
        return date2Str(date1, DATE_FORMAT_STANDARD_EN);
    }

    /**
     * 时间差值，
     *
     * @param date1
     * @param date2
     * @param stype 0 日，1 月，2 年
     * @return
     */
    public static int compareDate(String date1, String date2, int stype) {
        int n = 0;

        String[] u = {"天", "月", "年"};
        String formatStyle = "yyyy-MM-dd";

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        } catch (Exception e3) {
            System.out.println("wrong occured");
        }
        //List list = new ArrayList();
        while (!c1.after(c2)) {                     // 循环对比，直到相等，n 就是所要的结果
            //list.add(df.format(c1.getTime()));    // 这里可以把间隔的日期存到数组中 打印出来
            n++;
            if (stype == 1) {
                c1.add(Calendar.MONTH, 1);          // 比较月份，月份+1
            } else {
                c1.add(Calendar.DATE, 1);           // 比较天数，日期+1
            }
        }

        n = n - 1;

        if (stype == 2) {
            n = (int) n / 365;
        }

        System.out.println(date1 + " -- " + date2 + " 相差多少" + u[stype] + ":" + n);
        return n;
    }

    public static String getHourBetweenTwoDateString(String date1, String date2) {
        long time1 = dateToMillis(parseDate(date1, DATE_FORMAT_STANDARD));
        long time2 = dateToMillis(parseDate(date2, DATE_FORMAT_STANDARD));
        Float diff = Float.valueOf(Math.abs(time1 - time2));
        return String.valueOf(diff / MILLIS_PER_HOUR);
    }


    /**
     * 获取当前月的天数
     *
     * @param data
     * @return
     */
    public static int getMaxDay(String data) {
        String[] ym = data.split("-");
        int year = Integer.parseInt(ym[0]);
        int month = Integer.parseInt(ym[1]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    }


    /**
     * 根据时间获取当天00:00:00，和23:59:59,返回数组
     *
     * @param date
     * @return
     */
    public static List<Long> getBeginAndEndTimeThisDay(Date date) {
        List<Long> result = new ArrayList<>();
        String nowDate = date2Str(date, DateUtils.DATE_FORMAT_STANDARD_EN);
        Long beginTime = str2Date(nowDate + " 00:00:00").getTime();
        Long endTime = str2Date(nowDate + " 23:59:59").getTime();
        result.add(beginTime);
        result.add(endTime);
        return result;
    }

    public static String getDayBeforeCurrentDay(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 0 - i);
        return date2Str(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getFirstDayOfThisMonthByDay(String endDay) {
        Date date = getDate(endDay, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), "yyyy-MM-dd");
    }

    public static Date getDate(String dateStr, String pattern) {
        Date result = null;
        if (dateStr.trim().length() >= pattern.length()) {
            dateStr = dateStr.substring(0, pattern.length());
        }
        try {
            result = new SimpleDateFormat(pattern).parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException("DateUtils parse date fail: " + e.getMessage());
        }
        return result;
    }

    public static String getFirstDayOfThisYearByDay(String endDay) {
        Date date = getDate(endDay, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getMonthBeforeCurrentMonth(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0 - i);
        return date2Str(calendar.getTime(), "yyyy-MM");
    }

    public static String getFirstMonthOfThisYearByMonth(String endMonth) {
        Date date = getDate(endMonth, "yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
        return date2Str(calendar.getTime(), "yyyy-MM");
    }

    public static List<String> getEveryDayBetween(String beginDay, String endDay) {
        Date beginDate = getDate(beginDay, DATE_FORMAT_STANDARD_EN);
        Date endDate = getDate(endDay, DATE_FORMAT_STANDARD_EN);
        if (beginDate.after(endDate)) {
            throw new RuntimeException("起始日期比终止日期要晚！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        String dayStr = beginDay;
        SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> days = new ArrayList<>();
        do {
            days.add(dayStr);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            dayStr = ymdFormat.format(calendar.getTime());
        } while (dayStr.compareTo(endDay) <= 0);
        return days;
    }

    public static String getLastDayOfThisYearByDay(String endDay) {
        Date date = getDate(endDay, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return date2Str(calendar.getTime(), "yyyy-MM-dd");
    }

    public static String getLastMonthOfThisYearByMonth(String month) {
        Date date = getDate(month, "yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
        return date2Str(calendar.getTime(), "yyyy-MM");
    }

    public static List<String> getEveryMonthBetween(String beginMonth, String endMonth) {
        Date beginDate = getDate(beginMonth, DATE_FORMAT_YM_EN);
        Date endDate = getDate(endMonth, DATE_FORMAT_YM_EN);
        if (beginDate.after(endDate)) {
            throw new RuntimeException("起始日期比终止日期要晚！");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        String monthStr = beginMonth;
        SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM");
        List<String> months = new ArrayList<>();
        do {
            months.add(monthStr);
            calendar.add(Calendar.MONTH, 1);
            monthStr = ymdFormat.format(calendar.getTime());
        } while (monthStr.compareTo(endMonth) <= 0);
        return months;
    }

    /**
     * 获得当前系统时间之前的整点时间
     *
     * @return yyyy-MM-dd HH:00:00
     */
    public static String getIntegralTimeBeforeNow() {
        String nowStr = date2Str(new Date());
        String result = nowStr.substring(0, 13) + ":00:00";
        return result;
    }

    /**
     * 字符串转Long类型
     *
     * @param dateStr
     * @return
     */
    public static Long strToLong(String dateStr) {
        Long result = null;
        Date date = str2Date(dateStr);
        if (date != null) {
            result = date.getTime();
        }
        return result;
    }


    public static String longToStr(Long time) {
        String result = null;
        Date date = long2Date(time);
        result = date2Str(date);
        return result;

    }


    public static List<String> getHourSplitList(String beginTime,String endTime){
        List<String> result=new ArrayList<String>();
        long start =strToDateTime(beginTime.substring(0,13)+":00:00").getTime();
        long end = strToDateTime(endTime.substring(0,13)+":00:00").getTime();
        while(start<=end){
            String dataTime=dateToStr(new Date(start));
            result.add(dataTime);
            start+=1000*60*60;
        }
        return result;
    }

    /**
     * 字符串转时间
     * @param dateStr
     * @return
     */
    public static Date strToDateTime(String dateStr){
        if(null==dateStr || "".equals(dateStr)){
            return null;
        }
        Date result=null;
        try{
            result=formatter.parse(dateStr);
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }


    /**
     * 时间转字符串
     * @param date
     * @return
     */
    public static String dateToStr(Date date){
        if(date==null){
            return null;
        }
        String result=null;
        try{
            result=formatter.format(date);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


    // 获得本周一与当前日期相差的天数
    public static  int getMondayPlus() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    // 获得当前周- 周一的日期
    public static  String getCurrentMonday() {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();
        return date2Str(monday,"yyyy-MM-dd");
    }

    // 根据传参获得当前周- 周一的日期
    public static  String getCurrentMonday(int i) {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus+(7*i));
        Date monday = currentDate.getTime();
        return date2Str(monday,"yyyy-MM-dd");
    }


    // 根据传参获得当前周- 周日  的日期
    public static String getPreviousSunday(int i) {
        int mondayPlus = getMondayPlus();
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus +6+(7*i));
        Date monday = currentDate.getTime();
        return date2Str(monday,"yyyy-MM-dd");
    }


    //获取当前日期所在年的所属周数
    public static int getWeekNum(int i){
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR) + i;
    }

    //获取上周一的日期
    public static String getLastWeekMonday(){
        Calendar cal =Calendar.getInstance();
        try {
            cal.setTime(dateFormat.parse(getCurrentMonday()));
            cal.add(Calendar.DATE,-7);
            return  date2Str(cal.getTime(),"yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
    // 获得当前月--开始日期
    public static String getMinMonthDate() {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(getCurrentDate("yyyy-MM-dd")));
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return dateFormat.format(calendar.getTime());
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 获得当前月--结束日期
    public static String getMaxMonthDate(){
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(getCurrentDate("yyyy-MM-dd")));
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return dateFormat.format(calendar.getTime());
        }  catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}

