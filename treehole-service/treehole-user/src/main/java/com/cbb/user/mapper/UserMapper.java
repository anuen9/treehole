package com.cbb.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cbb.model.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
