package com.jiangjiawei.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.jiangjiawei.domain.User;
import com.jiangjiawei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String toLogin(){
        return "admin/login";
    }

    @PostMapping("/user/login")
    public String login(String name, String password, HttpSession session, Model model){
        System.out.println(name+"---"+password);
        password = DigestUtil.md5Hex(password);
        User user = userService.login(name,password);
        if(ObjectUtil.isEmpty(user)){
            model.addAttribute("tip","用户名或密码错误");
            return "redirect:/login";
        }
        session.setAttribute("user",user);
        return "redirect:/admin_index";
    }

    @GetMapping("/admin_index")
    public String admin_index(){
        return "admin/admin_index";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }
}
