package com.hxy.dao;

import com.hxy.pojo.Books;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Insert("insert into books(bookName, bookCounts, bookPrice, details) " +
            "values (#{bookName}, #{bookCounts}, #{bookPrice}, #{details})")
    int addBook(Books book);

    @Delete("delete from books where bookID=#{bookID}")
    int deleteBookById(int bookID);

    @Update("update books set bookName=#{bookName},bookCounts=#{bookCounts},bookPrice=#{bookPrice},details=#{details} " +
            "where bookID=#{bookID}")
    int updateBook(Books book);

    @Select("select * from book where bookID=#{bookID}")
    @Results({
            @Result(property = "bookID", column = "bookID"),
            @Result(property = "bookName", column = "bookName"),
            @Result(property = "bookCounts", column = "bookCounts"),
            @Result(property = "bookPrice", column = "bookPrice"),
            @Result(property = "details", column = "details")
    })
    Books queryBookById(int bookID);

    @Select("select * from books")
    @Results({
            @Result(property = "bookID", column = "bookID"),
            @Result(property = "bookName", column = "bookName"),
            @Result(property = "bookCounts", column = "bookCounts"),
            @Result(property = "bookPrice", column = "bookPrice"),
            @Result(property = "details", column = "details")
    })
    List<Books> queryAllBook();

    @Select("select count(*) from books")
    Long selectBookCount();
}
