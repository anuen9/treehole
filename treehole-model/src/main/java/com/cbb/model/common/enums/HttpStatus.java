package com.cbb.model.common.enums;

import lombok.Getter;

@Getter
public enum HttpStatus {
    SUCCESS(200, "操作成功"),
    NOT_FOUND(404, "查询不到"),
    LOGIN_ERR(401, "用户名或密码错误"),
    AUTH_ERR(403, "没有访问权限"),
    EMAIL_ERR(1, "邮箱错误"),
    ;

    final int code;
    final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
