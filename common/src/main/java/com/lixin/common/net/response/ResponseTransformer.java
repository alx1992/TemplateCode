package com.lixin.common.net.response;

import io.reactivex.ObservableTransformer;

/**
 * @author LiXin
 * @date 2019/9/11
 * @description ResponseTransformer was created 21:19
 */
public class ResponseTransformer {

    private ResponseTransformer(){}

    private static class ResponseTransformerHolder{
        private static final ResponseTransformer INSTANCE = new ResponseTransformer();
    }

    public static ResponseTransformer getInstance(){
        return ResponseTransformerHolder.INSTANCE;
    }

    public <T> ObservableTransformer<DataResponse<T>, T> handleResult() {
        return observable -> observable
                .onErrorResumeNext(new ErrorResumeFunction<>())
                .flatMap(new ResponseFunction<>());
    }
}
