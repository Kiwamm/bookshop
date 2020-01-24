package com.kiwammy.bookshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiwammy.bookshop.entity.User;
import com.kiwammy.bookshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
//验证用户的存在性
   @Autowired(required = false)
   private UserMapper userMapper;
    public String checkUser(String username)
    {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        User user=userMapper.selectOne(queryWrapper);
        if (user!=null)
        {
            return "exist";//用户存在
        }else
        {
            return "ok";//用户不存在
        }


    }


    /**
     * 验证用户是否可以登录
     */
    public String loginCheck(User user)
    {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",user.getUsername());
        User user1=userMapper.selectOne(queryWrapper);
        if(user1==null)
        {
            return "nameError";
        }
        else{
            if(user.getPassword().equals(user1.getPassword()))
            {
               return "success";
            }
            else{
                return "passwordError";
            }
        }
    }
}
