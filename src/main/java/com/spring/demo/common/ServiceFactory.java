package com.spring.demo.common;

import com.spring.demo.service.IQueryUserSV;
import com.spring.demo.service.QueryUserSVImpl;
import org.apache.commons.lang3.ClassUtils;

import java.io.IOException;
import java.util.Properties;


public class ServiceFactory {
    /*
     * 获取资源配置-service工厂
     *
     */
    public static Properties getProperties() {
        Properties props = new Properties();
        try {
            props.load(ServiceFactory.class.getClassLoader().getResourceAsStream("../resources/ApplicationResources.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static QueryUserSVImpl getUserService() {
        QueryUserSVImpl userService = null;
        //Properties props = getProperties();
        //String className = props.getProperty("QueryUserSVImpl");
        String className = "com.spring.demo.service.QueryUserSVImpl";
        try {
            userService = (QueryUserSVImpl) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userService;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

