package com.spring.demo.service;

import com.spring.demo.pojo.User;

import java.util.List;

public interface IQueryUserSV {
    // 查询客户信息
    public List<User> queryUser(String id);
}
