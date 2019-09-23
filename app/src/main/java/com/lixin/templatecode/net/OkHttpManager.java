package com.lixin.templatecode.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @author LiXin
 * @date 2019/9/20
 * @description OkHttpManager was created 15:57
 */
public class OkHttpManager {

    private static long CONNECT_TIMEOUT = 60L;
    private static long READ_TIMEOUT = 10L;
    private static long WRITE_TIMEOUT = 10L;
    private static OkHttpClient mOkHttpClient;

    /**
     * 内部静态类
      */
    private static class OkHttpManagerHolder {
        private static OkHttpManager INSTANCE = new OkHttpManager();
    }
    /**
     * 阻止实例化
     */
    private OkHttpManager() {
        initOkHttpClient();
    }

    /**
     * 初始化okhttpclient
     */
    private void initOkHttpClient() {

        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .build();
        }
    }

    /**
     * 获取OkHttpManager实例
     * @return
     */
    public static OkHttpManager getInstance() {
        return OkHttpManagerHolder.INSTANCE;
    }

    /**
     * 如果OkHttpClient为空，抛出异常
     */
    private static void testInitialize() {
        if (mOkHttpClient == null)
            throw new ExceptionInInitializerError("OkHttpClient初始化失败...");
    }

    /********************************************对外提供方法***************************************/
    /**
     * 获取OkHttpClient实例
     *
     * @return
     */
    public OkHttpClient getOkHttpClient() {
        testInitialize();
        return mOkHttpClient;
    }



}
