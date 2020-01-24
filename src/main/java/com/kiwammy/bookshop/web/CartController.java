package com.kiwammy.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kiwammy.bookshop.entity.Cart;
import com.kiwammy.bookshop.entity.CartVo;
import com.kiwammy.bookshop.entity.User;
import com.kiwammy.bookshop.entity.UserCartVo;
import com.kiwammy.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    /**
     * 商品加入购物车
     */
    @ResponseBody
    @RequestMapping("/add")
    public String add(@RequestBody Cart cart,@RequestHeader("userId") Integer userId )
    {
        cart.setUserId(userId);
        //判断是否已经在购物车存在该记录
        QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("user_id",userId);
        cartQueryWrapper.eq("book_id",cart.getBookId());
        Cart queryCart = cartService.getOne(cartQueryWrapper);
        if(queryCart == null){
            cartService.save(cart);
        } else {
            queryCart.setCount(queryCart.getCount() + cart.getCount());
            cartService.updateById(queryCart);
        }
        return "success";
    }


    /**
     * 查询当前用户的购物车
     */
    @ResponseBody
    @RequestMapping("/list")
    public List<CartVo> list(@RequestHeader("userId") Integer userId){
       List<CartVo> cartVos = cartService.findCartByUserId(userId);
        return cartVos;
    }

    /**
     * 显示有几个商品和总价是多少
     */
    @ResponseBody
    @RequestMapping("/total")
    public UserCartVo total(@RequestHeader("userId") Integer userId)
    {
        List<CartVo> list = cartService.findCartByUserId(userId);
        UserCartVo userCartVo=new UserCartVo();
        userCartVo.setNum(list.size());
        userCartVo.setTotalPrice(cartService.getCartItemTotal(list));
        return userCartVo;
    }


    /**
     * 删除购物车
     *
     */
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(@RequestHeader("userIds") String ids){
        return cartService.batchDelete(ids);
    }

}
