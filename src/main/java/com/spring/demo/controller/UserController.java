package com.spring.demo.controller;

import com.jdbc.demo.util.JDBCUtil;
import com.spring.demo.common.ServiceFactory;
import com.spring.demo.pojo.User;
import com.spring.demo.service.IQueryUserSV;
import com.spring.demo.service.QueryUserSVImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

/*
    springMVC映射路径
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 工厂模式
     */
    private QueryUserSVImpl sv = ServiceFactory.getUserService();
    /**
     *  使用注解方式
     */
    @Autowired
    private QueryUserSVImpl queryUserSV;

    // 拦截请求
    @RequestMapping("/index")
    // 请求参数获取注释格式
    public ModelAndView index(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        String userNames = userName;
        String passwords = password;
        System.out.println("++++++++++++++");
        ModelAndView view = new ModelAndView();
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("ID", "1000");
        map.put("NAME", "小波");
        list.add(map);
        view.addObject("studentList", list);
        //设置要跳转的页面，与返回值时String时返回success类似，以下跳转到/user/index.jsp
        view.setViewName("success");
        return view;
    }

    // 拦截请求
    @RequestMapping("/query")
    @ResponseBody
    // 请求参数获取注释格式-查询方法
    public JSONObject query(@RequestParam("page") String page, @RequestParam("limit") String limit) {
        /**
         * 测试数据
         * **/
        List list = new ArrayList();
        List<User> userList = null;
        Map map = null;
        Map<String, Object> result = new HashMap<String, Object>();
        for (int i = 0; i < 3; i++) {
            map = new HashMap();
            map.put("id", "1000" + i + "");
            map.put("username", "LIUBO");
            map.put("experience", "100");
            map.put("sex", "男");
            map.put("score", "100");
            map.put("city", "杭州");
            map.put("sign", "LIUBO");
            map.put("classify", "IT");
            map.put("wealth", "COMMON");
            list.add(map);
        }

        userList = sv.queryUser("1");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
            System.out.println("----------------");
        }
        JSONArray array = JSONArray.fromObject(userList);
        result.put("code", "0");
        result.put("msg", "成功");
        result.put("data", array);
        JSONObject jsonObject = JSONObject.fromObject(result);
        return jsonObject;
    }

    // 拦截请求
    @RequestMapping("/query0")
    @ResponseBody
    // 请求参数获取注释格式-查询方法
    public List query0(@RequestParam("billId") String billId) {
        List<Map<String, Object>> list = null;
        String sql = "select * from ins_user where user_phone = ?";
        list = JDBCUtil.executeQuery(sql, billId);
        return list;
    }
}
