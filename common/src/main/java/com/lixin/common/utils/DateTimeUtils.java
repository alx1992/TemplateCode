package com.lixin.common.utils;

import android.net.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiXin
 * @date 2019/12/3
 * @description DateTimeUtils was created 14:11
 */
public class DateTimeUtils {
    /**
     * 和当前系统时间比较
     * @param date      -- 需要和系统时间比较的时间
     * @return          -- 如果大于系统时间返回true,否则返回false
     */
    private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
    public static boolean compareDateWithNow(String date){
        //获取当前时间
        String nowDate = df.format(new Date(System.currentTimeMillis()));
        Date nowDt,_date;
        try {
            _date = df.parse(date);
            nowDt = df.parse(nowDate);
            if (_date.getTime() > nowDt.getTime()) {
                return true;
            }
        } catch (ParseException pE) {
            pE.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
}
