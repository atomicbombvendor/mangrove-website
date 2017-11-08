package com.mangrove.api.controller;

import com.alibaba.fastjson.JSON;
import com.mangrove.api.model.User;
import com.mangrove.api.service.UserService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jack on 2017/11/3.
 */
@RestController
@RequestMapping("/user")
@SessionAttributes("userId")
public class UserController {

    @Resource
    private UserService userService;


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response, String userName, String password) {

        User user = userService.getUser(userName, password);
        if (user == null) {
            return;
        }

        //设置session属性
//        Long uId = user.getUserId();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        session.setAttribute("userId", 1);
        session.setAttribute("userName", userName);
        session.setAttribute("password", password);

        Map<String, Object> result = new HashMap<>();
        result.put("userName", userName);

        //JSON 把单个Map写入JSON
        renderData(response, JSON.toJSONString(result));
    }



    /**
     * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
     **/
    private void renderData(HttpServletResponse response, String data) {
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.print(data);
            //print方法就是调用write方法实现的，也就是将object转换成String了而已。
            //还有就是print方法提供了多种数据类型，而write都通过转换，大多数变为字符串输出了
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != pw) {
                pw.flush();
                pw.close();
            }
        }
    }



}
