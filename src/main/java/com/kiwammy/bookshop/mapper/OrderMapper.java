package com.kiwammy.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kiwammy.bookshop.entity.Order;
import org.springframework.stereotype.Repository;


/**
 * @Auther: kiwammy
 *@Date: 2019/9/29 16:36
 * @Description:
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
//    /**
//     * 根据用户id查询用户订单以及订单明细
//     */
////    List<Order> findOrderAndOrderDetailListByUser(@Param("userId") Integer id, @Param("begin")Integer begin, @Param("end")Integer end);
//    List<Order> findOrderAndOrderDetailListByUser(OrderQueryVo orderQueryVo);
//
//    /**
//     * 查询记录总数
//     */
//    Integer findOrderCountByUser(OrderQueryVo orderQueryVo);
}
