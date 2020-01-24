package com.kiwammy.bookshop;

import com.kiwammy.bookshop.entity.Book;
import com.kiwammy.bookshop.mapper.BookMapper;
import com.kiwammy.bookshop.mapper.CartMapper;
import com.kiwammy.bookshop.service.BookService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookshopApplicationTests {
    @Autowired
    private CartMapper cartMapper;
    @Autowired(required = false)
    private BookMapper bookMapper;
    @Test
    public void context() {


    }
}
