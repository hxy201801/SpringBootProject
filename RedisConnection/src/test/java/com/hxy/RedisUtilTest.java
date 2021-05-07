package com.hxy;

import com.hxy.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

    @Resource
    private RedisUtils redisUtils;

    @Test
    public void set() {
        redisUtils.set("redis_key", "redis_value");
    }

    @Test
    public void get() {
        String value = redisUtils.get("redis_key");
        System.out.println(value);
    }




}
