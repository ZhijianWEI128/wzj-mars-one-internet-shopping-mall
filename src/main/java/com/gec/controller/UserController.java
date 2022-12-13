package com.gec.controller;

import com.gec.pojo.User;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller  //表示是一个控制层组件 告诉spring帮我们创建对象
public class UserController {

    @Autowired //注入对象
    UserService userService;

    @RequestMapping("/toLogin") //请求的路径
    public String toLogin(){
        //跳转到jsp
        return "login";//跳转页面    /WEB-INF/jsp/  login   .jsp
    }


    @RequestMapping("/doLogin")
    public String doLogin(User user, HttpSession session, Model model){//自动封装到对象 前提 name属性的值 如：loginName 要和User对象的属性名保持一致
        //查询用户名和密码是否正确
        User userByUSerNameAndPassword = userService.findUserByUserNameAndPassword(user);
        if(userByUSerNameAndPassword != null){//用户名和密码正确

            //登录成功保存 用户信息 session  一个会话范围    多个请求有效
            session.setAttribute("session_user",userByUSerNameAndPassword);

            return "forward:toIndex";

        }else {

            model.addAttribute("message","用户名或密码错误，请重新登录！！");

            return "login";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/doRegister")
    public String doRegister(User user,HttpSession session,Model model){
        User userByUserName=userService.finaUserByUserName(user);
        if (userByUserName.getLoginName()==null){
            session.setAttribute("session_user",user);
            return "forward:toIndex";//请求转发
        }else {
            model.addAttribute("message","该用户名已被使用！");
            return "register";
        }
    }
}
