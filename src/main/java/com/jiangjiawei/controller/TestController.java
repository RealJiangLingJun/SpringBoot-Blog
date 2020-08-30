package com.jiangjiawei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/navigation")
    public String navigation(){
        return "/navigation";
    }
}
