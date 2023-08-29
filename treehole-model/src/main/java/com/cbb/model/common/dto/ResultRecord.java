package com.cbb.model.common.dto;

import com.cbb.model.common.enums.HttpStatus;

/**
 * 响应记录，自动包含getter setter toString hashcode等方法
 * @param code http状态码
 * @param message 响应消息
 * @param data 响应体
 */

public record ResultRecord(int code, String message, Object data) {
    private static final Object DEFAULT_DATA = null;
    private static final int SUCCESS_CODE = HttpStatus.SUCCESS.getCode();
    private static final String SUCCESS_MSG = HttpStatus.SUCCESS.getMessage();

    public static ResultRecord ok() {
        return ok(SUCCESS_MSG, DEFAULT_DATA);
    }

    public static ResultRecord ok(String message) {
        return ok(message, DEFAULT_DATA);
    }

    public static ResultRecord ok(Object data) {
        return ok(SUCCESS_MSG, data);
    }

    public static ResultRecord ok(String message, Object data) {
        return new ResultRecord(SUCCESS_CODE, message, data);
    }

    public static ResultRecord fail(HttpStatus status) {
        return new ResultRecord(status.getCode(), status.getMessage(), DEFAULT_DATA);
    }
}
