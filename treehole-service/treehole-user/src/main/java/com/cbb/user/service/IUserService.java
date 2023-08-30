package com.cbb.user.service;

import com.cbb.model.common.dto.LoginDto;
import com.cbb.model.common.dto.ResultRecord;

public interface IUserService {
    ResultRecord sendCode(String email);

    ResultRecord login(LoginDto loginDto);
}
