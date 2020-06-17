package com.lixin.common.utils;

import android.app.Activity;

import com.blankj.utilcode.util.LogUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiXin
 * @date 2019/11/28
 * @description ActivityUtils was created 17:11
 */
public  class ActivityUtils {

    protected static String appName;

    /**
     * 维护Activity 的list
     */
    private static List<Activity> mActivities = Collections.synchronizedList(new LinkedList<>());

    public static String getAppName() {
        return appName;
    }

    /**
     * @param activity 作用说明 ：添加一个activity到管理里
     */
    public void pushActivity(Activity activity) {
        mActivities.add(activity);
        LogUtils.e("activityList:size:" + mActivities.size());
    }

    /**
     * @param activity 作用说明 ：删除一个activity在管理里
     */
    public void popActivity(Activity activity) {
        mActivities.remove(activity);
        LogUtils.e("activityList:size:" + mActivities.size());
    }

    /**
     * get current Activity 获取当前Activity（栈中最后一个压入的）
     */
    public static Activity currentActivity() {
        if (mActivities == null || mActivities.isEmpty()) {
            return null;
        }
        Activity activity = mActivities.get(mActivities.size() - 1);
        return activity;
    }

    /**
     * 结束当前Activity（栈中最后一个压入的）
     */
    public static void finishCurrentActivity() {
        if (mActivities == null || mActivities.isEmpty()) {
            return;
        }
        Activity activity = mActivities.get(mActivities.size() - 1);
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public static void finishActivity(Activity activity) {
        if (mActivities == null || mActivities.isEmpty()) {
            return;
        }
        if (activity != null) {
            mActivities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        if (mActivities == null || mActivities.isEmpty()) {
            return;
        }
        for (Activity activity : mActivities) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 按照指定类名找到activity
     *
     * @param cls
     * @return
     */
    public static Activity findActivity(Class<?> cls) {
        Activity targetActivity = null;
        if (mActivities != null) {
            for (Activity activity : mActivities) {
                if (activity.getClass().equals(cls)) {
                    targetActivity = activity;
                    break;
                }
            }
        }
        return targetActivity;
    }

    /**
     * @return 作用说明 ：获取当前最顶部activity的实例
     */
    public Activity getTopActivity() {
        Activity mBaseActivity = null;
        synchronized (mActivities) {
            final int size = mActivities.size() - 1;
            if (size < 0) {
                return null;
            }
            mBaseActivity = mActivities.get(size);
        }
        return mBaseActivity;

    }

    /**
     * @return 作用说明 ：获取当前最顶部的acitivity 名字
     */
    public String getTopActivityName() {
        Activity mBaseActivity = null;
        synchronized (mActivities) {
            final int size = mActivities.size() - 1;
            if (size < 0) {
                return null;
            }
            mBaseActivity = mActivities.get(size);
        }
        return mBaseActivity.getClass().getName();
    }

    /**
     * 结束所有Activity
     */
    public static void finishAllActivity() {
        if (mActivities == null) {
            return;
        }
        for (Activity activity : mActivities) {
            activity.finish();
        }
        mActivities.clear();
    }

    /**
     * 退出应用程序
     */
    public static void appExit() {
        try {
            LogUtils.e("app exit");
            finishAllActivity();
        } catch (Exception e) {
        }
    }

}
