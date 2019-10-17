package com.spring.demo.dao;

import com.spring.demo.common.DBUtil;
import com.spring.demo.mapper.UserMapper;
import com.spring.demo.pojo.User;
import org.apache.ibatis.session.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryUserDAOImpl implements IQueryUserDAO{
    // 查询客户信息
    public List<User> queryUser(String id){
        // 获取数据源连接
        SqlSession sqlSession = DBUtil.openSession();
        // 通过工厂获取服务方法
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.queryUser(id);
        return user;
    }
}
