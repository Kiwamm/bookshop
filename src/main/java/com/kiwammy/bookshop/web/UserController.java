package com.kiwammy.bookshop.web;

import com.kiwammy.bookshop.entity.User;
import com.kiwammy.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.rmi.server.RMIClassLoader;

@Controller
@RequestMapping("/user")
public class UserController {
    //验证用户是否存在
    @Autowired
    UserService userService;
    @ResponseBody
    @GetMapping("/checkUserName/{username}")
    public String checkUserName(@PathVariable(name="username") String username)
    {
        return userService.checkUser(username);
    }


    /**
     * 用户的注册接口
     */
    @ResponseBody
    @PostMapping("/register")
    public String register(@RequestBody User user)
    {
        userService.save(user);
        return "success";
    }


    /**
     * 用户登录
     */
    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody User user)
    {

        return userService.loginCheck(user);
    }

    /**
     * 安全退出
     */
    @ResponseBody
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "exit";
    }

}
