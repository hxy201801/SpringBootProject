package com.hxy;

import com.hxy.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

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



    /*
    @Autowired
    public RedisTemplate redisTemplate;

    @Test
    public void test() {

        // string
        redisTemplate.boundValueOps("str").set("hxy");
        System.out.println("str= " + redisTemplate.opsForValue().get("str"));

        redisTemplate.boundHashOps("hash_key").put("name", "java");
        redisTemplate.boundHashOps("hash_key").put("age", 13);

        Set set = redisTemplate.boundHashOps("hash_key").keys();
        System.out.println("hash key = " + set);

        List list = redisTemplate.boundHashOps("hash_key").values();
        System.out.println("hash values: " + list);

        //list 列表
        redisTemplate.boundListOps("list_key").leftPush("c");
        redisTemplate.boundListOps("list_key").leftPush("b");
        redisTemplate.boundListOps("list_key").leftPush("a");
        //获取全部元素
        list = redisTemplate.boundListOps("list_key").range(0, -1);
        System.out.println(" list列表中的所有元素：" + list);

        // set 集合
        redisTemplate.boundSetOps("set_key").add("a", "b", "c");
        set = redisTemplate.boundSetOps("set_key").members();
        System.out.println(" set集合中的所有元素：" + set);

        // sorted set 有序集合
        redisTemplate.boundZSetOps("sorted_set_key").add("d", 34);
        redisTemplate.boundZSetOps("sorted_set_key").add("e", 23);
        redisTemplate.boundZSetOps("sorted_set_key").add("f", 2);
        set = redisTemplate.boundZSetOps("sorted_set_key").range(0, -1);
        System.out.println(" sorted_set有序集合中的所有元素：" + set);

    } */
}
