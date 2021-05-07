package com.hxy.controller;

import com.hxy.service.BookService;
import com.hxy.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("allBook")
    public List<Books> allBook() {
        List<Books> list = bookService.queryAllBook();
        return list;
    }

    @GetMapping("/addBook")
    public String toAddBook(String bookName, int bookCounts, float bookPrice, String details) {
        Books books = new Books(bookName,bookCounts,bookPrice,details);
        bookService.addBook(books);
        return "Add successfully";
    }

    @GetMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        return "Update Successfully";
    }

    @GetMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookID) {
        bookService.deleteBookById(bookID);
        return "Delete successfully";
    }

    @GetMapping("/count")
    public String getBookCount() {
        Long count = bookService.getBookCount();
        return "Book Count : " + count.toString();
    }
}

