package edu.bdqn.ssm.controller;

import com.google.gson.Gson;
import edu.bdqn.ssm.entity.User;
import edu.bdqn.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    private  UserService userService;



    @RequestMapping("/login")
    public void login( User user,
                       HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ac", user.getAccount());
        map.put("pw", user.getPwd());
        // 1
        response.setContentType("text/html;charset=utf-8");
        // 2
        PrintWriter out = response.getWriter();
        int loginCount = this.userService.login(map);
        out.print(new Gson().toJson(loginCount));
        System.out.println(loginCount);
        out.close();
    }

    @RequestMapping("/loadUsersListPager")
    public ModelAndView loadUsersListPager(int currentPage,HttpServletResponse response) throws Exception{
        response.setCharacterEncoding("utf-8");
        PrintWriter out= response.getWriter();
        out.print(new Gson().toJson(this.userService.loadUsersListPager(currentPage)));
        System.out.println(new Gson().toJson(this.userService.loadUsersListPager(currentPage)));
        out.close();
        return null;
    }

    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute("user") User user,HttpServletResponse response) throws IOException {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("un", user.getUname());
        map.put("ac", user.getAccount());
        map.put("pw", user.getPwd());
        map.put("se", user.getSex());
        this.userService.saveUser(map);
        System.out.println(this.userService.saveUser(map));
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(this.userService.saveUser(map)));
        out.close();
        return null;
    }

    @RequestMapping("/delete")
    public ModelAndView delete( User user,HttpServletResponse response) throws IOException {
        int uid = user.getUid();
        userService.delete(uid);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(this.userService.delete(uid)));
        out.close();
        System.out.println(uid);
        return null;
    }
}
