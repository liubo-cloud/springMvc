package com.spring.demo.common;

import com.spring.demo.dao.IQueryUserDAO;
import com.spring.demo.dao.QueryUserDAOImpl;
import com.spring.demo.service.QueryUserSVImpl;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
        /*
         * 获取配置资源service、dao
         */
        public static Properties getProperties() {
            Properties props = new Properties();
            try {
                // 配置资源所在路径
                props.load(DaoFactory.class.getResourceAsStream("../../ApplicationResources.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return props;
        }

        public static QueryUserDAOImpl getUserDao() {
            QueryUserDAOImpl userDao = null;
            //Properties props = getProperties();
            //String className = props.getProperty("QueryUserDAOImpl");
            String className = "com.spring.demo.dao.QueryUserDAOImpl";
            try {
                userDao = (QueryUserDAOImpl) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return userDao;
        }

}
