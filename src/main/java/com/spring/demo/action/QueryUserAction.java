package com.spring.demo.action;

import com.opensymphony.xwork2.Action;
/*
    struts2 实现Action类的写法
    必须重写excute方法
 */
public class QueryUserAction implements Action {
    private String userName;
    private String password;

    // 重写Action中的方法excute
    public String execute() throws Exception{
        System.out.println("姓名:"+userName);
        System.out.println("密码:"+password);
        if (userName.equals("xiaobo") && password.equals("xiaobo")) {
            return "success";
        }
        return "error";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
