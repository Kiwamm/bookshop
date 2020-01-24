package com.kiwammy.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kiwammy.bookshop.entity.Address;
import com.kiwammy.bookshop.entity.CartVo;
import com.kiwammy.bookshop.entity.User;
import com.kiwammy.bookshop.service.AddressService;
import com.kiwammy.bookshop.service.CartService;
import com.kiwammy.bookshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: jzhang
 * @Date: 2019/9/29 14:20
 * @Description: 订单控制器
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderService orderService;

    /**
     * 把用户购物车里选中的id提取列出来
     */
    @ResponseBody
    @RequestMapping("/confirm")
    public List<CartVo> confirm(@RequestHeader("ids") String ids){
        //通过购物车里的id查询记录
        String [] ids1=ids.split(",");
        List<CartVo> cartVos = cartService.findCartByIds(ids1);
         return cartVos;
    }
//
//    /**
//     * 提交订单
//     */
//    @RequestMapping("/commitOrder")
//    public String commitOrder(Integer addrId, HttpSession session){
//        List<CartVo> cartVos = (List<CartVo>) session.getAttribute("cartVos");
//        String flag = orderService.buy(cartVos,addrId,session);
//        if(flag.equals("success")){
//            //跳转至订单列表页
//            return "redirect:/order/list";
//        }else {
//            return "redirect:/book/index";
//        }
//    }



}
