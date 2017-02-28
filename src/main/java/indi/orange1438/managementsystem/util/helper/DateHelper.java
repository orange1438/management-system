package indi.orange1438.managementsystem.util.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 线程安全
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         data: 2017/02/18 22:29
 */
public class DateHelper {
    //默认格式
    private static String datePattern = "yyyy-MM-dd";
    private static String timePattern = datePattern + " HH:mm:ss";

    /**
     * 日期转为字符串
     *
     * @param aDate
     * @return
     */
    public synchronized static final String date2Str(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate != null) {
            df = new SimpleDateFormat(timePattern);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 日期转为字符串
     *
     * @param aDate
     * @param pattern
     * @return
     */
    public synchronized static final String date2Str(Date aDate, String pattern) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate != null) {
            df = new SimpleDateFormat(pattern);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 字符串转为日期，失败返回null
     *
     * @param strDate
     * @param pattern
     * @return
     * @throws ParseException
     */
    public synchronized static final Date str2Date(String strDate, String pattern) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(pattern);
        try {
            date = df.parse(strDate);
        } catch (Exception pe) {
            return null;
        }
        return (date);
    }

    /**
     * 字符串转为日期，失败返回null
     *
     * @param strDate
     * @return
     * @throws ParseException
     */
    public synchronized static final Date str2Date(String strDate) {
        return str2Date(strDate, timePattern);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public synchronized static String getTimeNow() {
        Date nowTime = new Date();
        return date2Str(nowTime);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public synchronized static Date getDateTimeNow() {
        SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
        try {
            return sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前时间
     *
     * @param pattern 时间格式
     * @return
     */
    public synchronized static String getTimeNow(String pattern) {
        Date nowTime = new Date();
        return date2Str(nowTime, pattern);
    }

    /***
     * 获取当前时间的前部分
     * @return
     */
    public synchronized static String getStringDateShort(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /***
     * 获取当前时间的后部分
     * @return
     */
    public synchronized static String getTimeShort(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 得到日期时间
     *
     * @param createTime
     * @return
     */
    public synchronized static String simpleDate(Date createTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        String dateString = formatter.format(createTime);
        return dateString;
    }

    /**
     * 加减天数
     *
     * @param date
     * @param dayOffset [+-]
     * @return
     */
    public synchronized static Date addDay(Date date, int dayOffset) {
        long oneDayMillisecond = dayOffset * 24 * 60 * 60 * 1000;
        return new Date(date.getTime() + oneDayMillisecond);
    }

    /**
     * 获得当前前后任何时候的日期
     *
     * @param d          当天日期的偏移量，如查明天d就为1，昨天：-1，后天：2；以此类推
     * @param dateFormat 时间格式
     * @return
     */
    public synchronized static String getDateString(int d, String dateFormat) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.get(Calendar.DATE) + (d));
        SimpleDateFormat sd = new SimpleDateFormat(dateFormat);
        return sd.format(c.getTime());
    }

    /**
     * 获得当前前后任何时候的日期
     *
     * @param d 当天日期的偏移量，如查明天d就为1，昨天：-1，后天：2；以此类推
     * @return
     */
    public synchronized static String getDateString(int d) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, c.get(Calendar.DATE) + (d));
        SimpleDateFormat sd = new SimpleDateFormat(timePattern);
        return sd.format(c.getTime());
    }

    /**
     * 获取当前日期的下一秒时间
     *
     * @param dateStr 日期 格式为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public synchronized static String getNextSecondDateStr(String dateStr) {
        if (dateStr == null || "".equals(dateStr)) {
            return dateStr;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = new Date(sdf.parse(dateStr).getTime() + 1000);
            dateStr = sdf.format(date);
        } catch (ParseException e) {
        }
        return dateStr;
    }

    /**
     * 判断是否是当月最后一天
     *
     * @return
     */
    public synchronized static boolean isLastDay() {
        boolean isLastDay = false;
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1; //当前月
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DAY_OF_MONTH, 1);
        int month2 = cal2.get(Calendar.MONTH) + 1; //加1天后的月
        if (month != month2) { //表示当前时间是当月的最后一天
            isLastDay = true;
        }
        return isLastDay;
    }

    /**
     * 判断是否是当月最后一天
     * Date date 当前时间
     *
     * @return
     */
    public synchronized static boolean isLastDay(Date date) {
        synchronized (DateHelper.class) {
            boolean isLastDay = false;
            Calendar cal = Calendar.getInstance();
            int month = cal.get(Calendar.MONTH) + 1; //当前月
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date);
            cal2.add(Calendar.DAY_OF_MONTH, 1);
            int month2 = cal2.get(Calendar.MONTH) + 1; //加1天后的月
            if (month != month2) { //表示当前时间是当月的最后一天
                isLastDay = true;
            }
            return isLastDay;
        }
    }

    /**
     * 获取当天开始时间
     *
     * @param date
     * @return
     */
    public synchronized static Date getDayStartTime(Date date) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当天结束时间
     *
     * @param date
     * @return
     */
    public synchronized static Date getDayEndTime(Date date) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(date);
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * @param s start 开始时间
     * @param e end 结束时间
     * @return boolean
     * @throws
     * @Title: 比较时间
     * @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
     * @author luguosui
     */
    public synchronized static boolean compareDate(String s, String e) {
        Date start = str2Date(s, "yyyy-MM-dd");
        Date end = str2Date(e, "yyyy-MM-dd");
        if (start == null || end == null) {
            return false;
        }
        return start.getTime() >= end.getTime();
    }

    /**
     * 校验日期是否合法
     *
     * @return
     */
    public synchronized static boolean isValidDate(String s) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fmt.parse(s);
            return true;
        } catch (Exception e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            return false;
        }
    }

    /**
     * 时间相减得到天数
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public synchronized static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate = null;
        java.util.Date endDate = null;

        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    /**
     * 得到n天之后是周几
     *
     * @param days
     * @return
     */
    public synchronized static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);

        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);

        return dateStr;
    }

    /**
     * 把时间根据周、日、时、分、秒转换为时间段
     *
     * @param strDate
     * @return
     */
    public static String getTimes(String strDate) {
        String resultTimes = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = df.parse(strDate);
            Date nowTime = new Date();
            long times = nowTime.getTime() - date.getTime();

            long sec = times / 1000;
            long min = sec / 60;
            long hour = min / 60;
            long day = hour / 24;
            long week = day / 7;

            StringBuffer sb = new StringBuffer();
            if (week > 2) {
                //大于两周就直接显示时间
                SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd HH:mm");
                String dateString = formatter.format(date);
                sb.append(dateString);
            } else if (week > 0) {
                sb.append(week + "周前");
            } else if (day > 0) {
                sb.append(day + "天前");
            } else if (hour > 0) {
                sb.append(hour + "小时前");
            } else if (min > 0) {
                sb.append(min + "分钟前");
            } else {
                sb.append(sec + "秒前");
            }
            resultTimes = sb.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultTimes;
    }
}
