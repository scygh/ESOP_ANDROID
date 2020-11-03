package com.scy.common.entity;

import com.scy.common.base.BaseConstants;

import java.io.Serializable;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 10:44
 */
public class BaseResponse<T> implements Serializable {
    private T Content;
    private boolean Result;
    private String Message;
    private int StatusCode;

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        if (StatusCode == BaseConstants.RequestSuccess) {
            return true;
        } else {
            return false;
        }
    }

    public T getContent() {
        return Content;
    }

    public boolean isResult() {
        return Result;
    }

    public String getMessage() {
        return Message;
    }

    public int getStatusCode() {
        return StatusCode;
    }
}

