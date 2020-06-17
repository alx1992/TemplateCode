package com.lixin.common.net;


import com.lixin.common.base.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author LiXin
 * @date 2019/9/10
 * @description NetWorkManager was created 21:56
 */
public class RetrofitManager {

    private static RetrofitManager mInstance;
    private static Retrofit retrofit;

    /**
     * 阻止NetWorkManager实例化
     */
    private RetrofitManager() {
        initRetrofit();
    }
    /**
     * 初始化必要对象和参数
     */
    private void initRetrofit() {
        if (retrofit == null) {
            // 初始化Retrofit
            retrofit = new Retrofit.Builder()
                    .client(OkHttpManager.getInstance().getOkHttpClient())
                    .baseUrl(Constants.HOST)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    /**
     * 对外提供NetWorkManager的实例
     * @return
     */
    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 如果Retrofit为空，抛出异常
     */
    private static void testInitialize() {
        if (retrofit == null)
            throw new ExceptionInInitializerError("Retrofit初始化失败...");
    }

    /****************************************对外提供的方法******************************************/
    /**
     * 获取Service
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getApiService(Class<T> clazz) {
        testInitialize();
        return retrofit.create(clazz);
    }



}
