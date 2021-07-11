package com.jiangjiawei.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是一个全局的异常处理类
 */

//这个注解可以帮助我们获取全局的异常信息
@ControllerAdvice
public class ExceptionHandle {


    //定义要处理的处理的异常种类，需要一场本身作为参数
    @ExceptionHandler(Exception.class)
    public ModelAndView handle(Exception e, HttpServletRequest request, HttpServletResponse response){
        e.printStackTrace();//打印异常信息
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/error");
        mv.addObject("exception",e);
        mv.addObject("url",request.getRequestURL());//发生异常的路径

        return mv;
    }

}
