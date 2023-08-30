package com.cbb.user.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cbb.model.common.constant.RedisConst;
import com.cbb.model.common.dto.LoginDto;
import com.cbb.model.common.dto.ResultRecord;
import com.cbb.model.common.enums.HttpStatus;
import com.cbb.model.user.entity.User;
import com.cbb.user.mapper.UserMapper;
import com.cbb.user.service.IUserService;
import com.cbb.utils.CacheClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final CacheClient cacheClient;

    @Override
    public ResultRecord sendCode(String email) {
        boolean isEmail = Validator.isEmail(email);
        if (!isEmail) {
            return ResultRecord.fail(HttpStatus.EMAIL_ERR);
        }
        String code = RandomUtil.randomNumbers(6);
        cacheClient.set(RedisConst.LOGIN_CODE, email, code);
        // todo 发送验证码到邮箱
        log.info("===> 发送出的验证码：{}", code);
        return ResultRecord.ok();
    }

    @Override
    public ResultRecord login(LoginDto loginDto) {
        String email = loginDto.getEmail();
        String code = loginDto.getCode();
        boolean isEmail = Validator.isEmail(email);
        if (!isEmail) {
            return ResultRecord.fail(HttpStatus.EMAIL_ERR);
        }
        String cacheCode = cacheClient.acquire(RedisConst.LOGIN_CODE, email, String.class);
        log.info("===> 缓存中的验证码：{}", cacheCode);
        if (cacheCode == null || !cacheCode.equals(code)) {
            return ResultRecord.fail(HttpStatus.LOGIN_ERR);
        }
        // todo 1.判断数据库中是否有该记录，如果有则直接登录成功，如果没有则注册
        // todo 2.在缓存中维护一个存活时间为30分钟的记录，
        return null;
    }
}
