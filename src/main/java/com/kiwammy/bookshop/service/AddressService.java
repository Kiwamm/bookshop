package com.kiwammy.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiwammy.bookshop.entity.Address;
import com.kiwammy.bookshop.mapper.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends ServiceImpl<AddressMapper, Address> {
}
