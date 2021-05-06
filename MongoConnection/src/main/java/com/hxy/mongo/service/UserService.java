package com.hxy.mongo.service;

import com.hxy.mongo.bean.UserData;
import com.hxy.mongo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveUser(UserData user) {
        userDao.save(user);
    }

    public List<UserData> findAll() {
        return userDao.findAll();
    }

    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

}
