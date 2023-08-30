package com.cbb.model.common.constant;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public enum RedisConst {
    LOGIN_CODE("login:code:", 2L, TimeUnit.MINUTES),
    LOGIN_USER("login:auth:", 30L, TimeUnit.MINUTES),
    ;
    final String prefix;
    final Long TTL;
    final TimeUnit timeUnit;

    RedisConst(String prefix, Long ttl, TimeUnit timeUnit) {
        this.prefix = prefix;
        this.TTL = ttl;
        this.timeUnit = timeUnit;
    }
}
