package com.kiwammy.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kiwammy.bookshop.entity.Book;
import com.kiwammy.bookshop.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
 * @Auther: jzhang
 * @Date: 2019/9/24 09:56
 * @Description: 图书业务层
 */
@Service
public class BookService extends ServiceImpl<BookMapper,Book> {
}
