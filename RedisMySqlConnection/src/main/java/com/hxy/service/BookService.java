package com.hxy.service;

import com.hxy.dao.BookMapper;
import com.hxy.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

@Service
public class BookService {

    private final static String BOOKCOUNT_KEY = "bookCount";

    @Autowired(required = false)
    private BookMapper bookMapper;

    public RedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    public int addBook(Books book) {
        this.clearRedis();
        return this.bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        this.clearRedis();
        return this.bookMapper.deleteBookById(id);
    }

    public int updateBook(Books book) {
        this.clearRedis();
        return this.bookMapper.updateBook(book);
    }

    public Books queryBookById(int id) {
        return this.bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return this.bookMapper.queryAllBook();
    }

    public Long getBookCount() {
        Long bookCount;
        String bookCountStr = (String)redisTemplate.opsForValue().get(BOOKCOUNT_KEY);
        if (bookCountStr == null) {
            System.out.println("Get count from mybatis");
            bookCount = this.bookMapper.selectBookCount();
            redisTemplate.opsForValue().set(BOOKCOUNT_KEY, bookCount.toString());
        } else {
            bookCount = Long.valueOf(bookCountStr);
            System.out.println("Get count from redis");
        }
        return bookCount;
    }

    private void clearRedis() {
        try {
            redisTemplate.delete(BOOKCOUNT_KEY);
        } catch (Exception e) {
        }

    }
}
