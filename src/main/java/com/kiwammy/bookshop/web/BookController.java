package com.kiwammy.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kiwammy.bookshop.entity.Book;
import com.kiwammy.bookshop.mapper.BookMapper;
import com.kiwammy.bookshop.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.kiwammy.bookshop.entity.enums.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: jzhang
 * @Date: 2019/9/24 10:10
 * @Description: 图书控制器
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired(required = false)
    private BookMapper bookMapper;

//    @RequestMapping("/bookData")
//    public List<Book> getBookData()
//    {
//        List<Book> bookList = bookMapper.selectList(null);
//        return bookList;
//    }

    /**
     *
     * 分页查询所有数据
     */
    @PostMapping("/allBook")
    public List<Book> selectAll(Integer page ,Integer size)//第一个整数为当前页数，第二个为每页展示多少个
    {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("id");
        IPage<Book> iPage = bookService.page(new Page<Book>(page,size),queryWrapper);
        return iPage.getRecords();
    }

    //按id删除书本
    @DeleteMapping("/delete/{id}")
    public String  deleteBook(@PathVariable(name = "id") String id)
    {
        bookService.removeById(id);
        return "sucess";
    }

//增加书本信息
    @PostMapping("/add")
    public String addBook(@RequestBody Book book)
    {
        bookService.save(book);
        return "success";
    }

    /**
     * 改变图书信息
     */
@PutMapping("/change")
    public Book  changeBook(@RequestBody Book book)
{
    bookService.updateById(book);
    return book;
}


//
//    /**
//     * 获取图书信息
//     */
//
//    @RequestMapping("/getBookData")
//    public String getBookData(Model model,Integer page,Integer category){
//        //mybatis plus分页
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("category",category);
//        IPage<Book> iPage = bookService.page(new Page<>(page,4),queryWrapper);
//        System.out.println(iPage.getRecords());
//
//
//
//        return "hello word";
//    }

    /**
     * 图书列表页
     */
//    @RequestMapping("/bookList")
//    public String bookList(String category, Model model){
//        model.addAttribute("category",category);
//        return "books_list";
//    }

    /**
     * 获取图书列表数据
     */
//    @RequestMapping("/getBookListData")
//    public String getBookListData(String category,Integer page, Integer pageSize, Model model){
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("category",category);
//        IPage<Book> iPage = bookService.page(new Page<Book>(page,pageSize),queryWrapper);
//        model.addAttribute("bookList",iPage.getRecords());
//        model.addAttribute("pre",iPage.getCurrent() - 1);
//        model.addAttribute("next",iPage.getCurrent() + 1);
//        model.addAttribute("cur",iPage.getCurrent());
//        model.addAttribute("pages",iPage.getPages());
//        model.addAttribute("category",category);
//        model.addAttribute("pageSize",pageSize);
//        return "booksListData";
//    }

    /**
     * 图书详情
     */
//    @RequestMapping("/detail")
//    public String detail(Integer id,Model model){
//        Book book = bookService.getById(id);
//        model.addAttribute("book",book);
//        return "details";
//    }
//
}
