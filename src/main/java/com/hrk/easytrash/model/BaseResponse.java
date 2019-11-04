package com.hrk.easytrash.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: hrk
 * @Date: 2019-07-04 16:43
 * @Description:
 */
@Getter
@Setter
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse success() {
        return new BaseResponse(200, "success");
    }

    public static BaseResponse success(Object data) {
        return new BaseResponse<>(200, "success", data);
    }

    public static BaseResponse fail() {
        return new BaseResponse(500, "failed");
    }

    public static BaseResponse fail(String message) {
        return new BaseResponse(500, message);
    }
}
