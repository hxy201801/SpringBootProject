package com.hxy.mongo.dao;

import com.hxy.mongo.bean.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<UserData, Integer> {
}
