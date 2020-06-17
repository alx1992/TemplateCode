package com.lixin.common.net.response;

/**
 * @author LiXin
 * @date 2019/9/10
 * @description Response was created 21:57
 */
public class DataResponse<T> {

    private int result; // 返回的code
    private T data; // 具体的数据结果
    private String msg; // message 可用来返回接口的说明

    public int getResult() {
        return result;
    }

    public void setResult(int pResult) {
        result = pResult;
    }

    public T getData() {
        return data;
    }

    public void setData(T pData) {
        data = pData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String pMsg) {
        msg = pMsg;
    }
}