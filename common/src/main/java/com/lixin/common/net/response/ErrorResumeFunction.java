package com.lixin.common.net.response;


import com.lixin.common.net.exception.CustomException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @author LiXin
 * @date 2019/9/11
 * @description ErrorResumeFunction was created 21:26
 */
public class ErrorResumeFunction<T>
        implements Function<Throwable, ObservableSource<? extends DataResponse<T>>> {
    /**
     * 非服务器产生的异常，比如本地无无网络请求，Json数据解析错误等等。
     * @param throwable
     * @return
     * @throws Exception
     */
    @Override
    public ObservableSource<? extends DataResponse<T>> apply(Throwable throwable) throws Exception {
        return Observable.error(CustomException.handleException(throwable));
    }
}
