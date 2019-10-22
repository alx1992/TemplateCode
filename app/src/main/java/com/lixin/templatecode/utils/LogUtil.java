package com.lixin.templatecode.utils;

import android.util.Log;

import com.lixin.templatecode.BuildConfig;

public class LogUtil {
    // 发布时将此设置为false，禁用调试信息
    private static final boolean allowed = BuildConfig.DEBUG;

    public static void i(String TAG, String msg) {
        if (allowed) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (allowed) {
            Log.w(TAG, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (allowed) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (allowed) {
            Log.e(TAG, msg);
        }
    }

    public static void v(String TAG, String msg) {
        if (allowed) {
            Log.v(TAG, msg);
        }
    }

}
