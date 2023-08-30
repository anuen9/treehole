package com.cbb.utils;

import com.alibaba.fastjson2.JSONObject;
import com.cbb.model.common.constant.RedisConst;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CacheClient {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void set(RedisConst basicInf, String key, Object value) {
        key = basicInf.getPrefix() + key;
        String valueStr = JSONObject.toJSONString(value);
        stringRedisTemplate.opsForValue().set(key, valueStr, basicInf.getTTL(), basicInf.getTimeUnit());
    }

    public <R> R acquire(RedisConst basicInf, String key, Class<R> rClass) {
        key = basicInf.getPrefix() + key;
        String valueStr = stringRedisTemplate.opsForValue().get(key);
        return JSONObject.parseObject(valueStr, rClass);
    }
}
