package com.jiangjiawei.controller.adminController;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.jiangjiawei.domain.User;
import com.jiangjiawei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class AdminUserController {

    @Autowired
    private UserService userService;

    //前往登录页面
    @GetMapping("/login")
    public String toLogin(){
        return "admin/login";
    }

    //判断是否可登录，并前往相应页面
    //这里的请求只能使用 /user/login 不能使用 admin/login ,因为有拦截器的存在
    @PostMapping("/user/login")
    public String login(String name, String password, HttpSession session, Model model){
        password = DigestUtil.md5Hex(password);
        User user = userService.login(name,password);
        if(ObjectUtil.isEmpty(user)){
            model.addAttribute("tip","用户名或密码错误");
            return "admin/login";
        }
        session.setAttribute("user",user);
        return "redirect:/admin/admin_navigation";
    }

    //查看头像
    @GetMapping("/admin/checkHead")
    public String checkHead(HttpSession session){
        String icon = ((User)session.getAttribute("user")).getIcon();
        System.out.println(icon);
        return icon;
    }

    //登出，前往登录页面
    @GetMapping("/admin/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
