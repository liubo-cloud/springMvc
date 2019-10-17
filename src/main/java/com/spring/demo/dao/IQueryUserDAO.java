package com.spring.demo.dao;

import com.spring.demo.pojo.User;

import java.util.List;

public interface IQueryUserDAO {
    // 查询客户信息
    public List<User> queryUser(String id);
}
