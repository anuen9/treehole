package com.cbb.user.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cbb.model.common.dto.LoginDto;
import com.cbb.model.common.dto.ResultRecord;
import com.cbb.model.common.enums.HttpStatus;
import com.cbb.model.user.entity.User;
import com.cbb.user.mapper.UserMapper;
import com.cbb.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public ResultRecord sendCode(LoginDto loginDto) {
        String email = loginDto.getEmail();
        boolean isEmail = Validator.isEmail(email);
        if (!isEmail) {
            return ResultRecord.fail(HttpStatus.EMAIL_ERR);
        }
        String code = RandomUtil.randomNumbers(6);
        // todo 发送验证码到邮箱
        log.info("===> 验证码：{}", code);
        stringRedisTemplate.opsForValue().set("test", "testvalue");
        return null;
    }
}
