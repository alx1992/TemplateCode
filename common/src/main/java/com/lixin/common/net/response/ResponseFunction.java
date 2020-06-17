package com.lixin.common.net.response;


import com.lixin.common.net.exception.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * @author LiXin
 * @date 2019/9/11
 * @description ResponseFunction was created 21:28
 */
public class ResponseFunction<T>
        implements Function<DataResponse<T>, ObservableSource<T>> {
    /**
     * 服务其返回的数据解析
     * 正常服务器返回数据和服务器可能返回的exception
     * @param tDataResponse
     * @return
     * @throws Exception
     */
    @Override
    public ObservableSource<T> apply(DataResponse<T> tDataResponse) throws Exception {
        int code = tDataResponse.getResult();
        String message = tDataResponse.getMsg();
        //根据自己项目返回设置code返回值
        if (code == 0) {
            return Observable.just(tDataResponse.getData());
        } else {
            return Observable.error(new ApiException(code, message));
        }
    }
}
