package com.spring.demo.service;

import com.spring.demo.common.DaoFactory;
import com.spring.demo.dao.IQueryUserDAO;
import com.spring.demo.dao.QueryUserDAOImpl;
import com.spring.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryUserSVImpl implements IQueryUserSV{
    /**
     * 工厂模式
     */
    private QueryUserDAOImpl dao = DaoFactory.getUserDao();
    /**
     * 使用注解方式注入
     */
    @Autowired
    private QueryUserDAOImpl queryUserDAO;

    // 查询客户信息
    public List<User> queryUser(String id){
        List<User> user = dao.queryUser(id);
        return user;
    }
}
