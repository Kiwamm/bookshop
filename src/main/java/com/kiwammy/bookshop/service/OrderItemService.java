package com.kiwammy.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiwammy.bookshop.entity.OrderItem;
import com.kiwammy.bookshop.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

/**
 * @Auther: jzhang
 * @Date: 2019/9/29 16:37
 * @Description:
 */
@Service
public class OrderItemService extends ServiceImpl<OrderItemMapper, OrderItem> {
}
