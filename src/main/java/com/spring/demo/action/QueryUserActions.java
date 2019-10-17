package com.spring.demo.action;
/*
    不实现Action接口的方式
 */
public class QueryUserActions {
    private String userName;
    private String password;

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

    public String queryUsers() throws Exception {
        System.out.println("queryUser    姓名:" + userName);
        System.out.println("queryUser    密码:" + password);
        if (userName.equals("xiaobo") && userName.equals("xiaobo")) {
            return "success";
        }
        return "error";

    }
}
