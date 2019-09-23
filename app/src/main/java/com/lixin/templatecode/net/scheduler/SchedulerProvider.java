package com.lixin.templatecode.net.scheduler;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * @author LiXin
 * @date 2019/9/4
 * @description SchedulerProvider was created 17:03
 */
public class SchedulerProvider implements BaseSchedulerProvider {

    //防止直接实例化
    private SchedulerProvider() {
    }

    private static class SchedulerProviderHolder{
        private static SchedulerProvider INSTANCE = new SchedulerProvider();
    }

    public static synchronized SchedulerProvider getInstance() {
        return SchedulerProviderHolder.INSTANCE;
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @NonNull
    @Override
    public <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable
                .subscribeOn(io())
                .observeOn(ui());
    }
}
