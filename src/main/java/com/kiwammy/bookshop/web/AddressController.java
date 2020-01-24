package com.kiwammy.bookshop.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kiwammy.bookshop.entity.Address;
import com.kiwammy.bookshop.entity.CartVo;
import com.kiwammy.bookshop.entity.User;
import com.kiwammy.bookshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: kiwammy
 * @Date: 2019/9/29 16:02
 * @Description: 地址控制器
 */
@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @ResponseBody
    @RequestMapping("/save")
    public String save(@RequestBody Address address, @RequestHeader("userId")Integer userId){
        address.setUserId(userId);
       if(address.getIsDefault() != null && address.getIsDefault().equals("on")){
            address.setIsDefault("1");
        }
        addressService.save(address);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Address> listAddress(@RequestHeader("userId") Integer userId)
    {
          //获取当前用户的收货地址
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq("user_id",userId);
        List<Address> addressList = addressService.list(addressQueryWrapper);
        return  addressList;
    }

    @ResponseBody
    @RequestMapping("/list/{id}")
    public Address showAddress(@PathVariable(name = "id") String id)
    {

        return addressService.getById(id);
    }
}
