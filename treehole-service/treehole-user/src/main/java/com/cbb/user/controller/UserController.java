package com.cbb.user.controller;

import com.cbb.model.common.dto.LoginDto;
import com.cbb.model.common.dto.ResultRecord;
import com.cbb.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "用户相关API")
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Operation(summary = "用户获取验证码")
    @PostMapping("/code")
    public ResultRecord sendCode(@RequestBody LoginDto loginDto) {
        return userService.sendCode(loginDto);
    }
}

