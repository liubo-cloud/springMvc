package com.spring.demo.mapper;

import com.spring.demo.pojo.User;

import java.util.List;

public interface UserMapper {
    // 查询客户信息
    public List<User> queryUser(String userId);
}
