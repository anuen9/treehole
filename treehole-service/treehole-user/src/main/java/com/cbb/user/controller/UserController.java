package com.cbb.user.controller;

import com.cbb.model.common.dto.LoginDto;
import com.cbb.model.common.dto.ResultRecord;
import com.cbb.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Email;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "用户相关API")
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Operation(summary = "用户获取验证码")
    @PostMapping("/code")
    public ResultRecord sendCode(@RequestParam String email) {
        return userService.sendCode(email);
    }

    public ResultRecord login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }
}

