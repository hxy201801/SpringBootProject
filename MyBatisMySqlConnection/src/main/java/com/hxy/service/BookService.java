package com.hxy.service;

import com.hxy.dao.BookMapper;
import com.hxy.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired(required = false)
    private BookMapper bookMapper;

    public int addBook(Books book) {
        return this.bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return this.bookMapper.deleteBookById(id);
    }

    public int updateBook(Books book) {
        return this.bookMapper.updateBook(book);
    }

    public Books queryBookById(int id) {
        return this.bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return this.bookMapper.queryAllBook();
    }
}
