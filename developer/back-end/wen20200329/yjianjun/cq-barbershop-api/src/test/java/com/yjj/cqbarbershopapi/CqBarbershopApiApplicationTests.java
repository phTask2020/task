package com.yjj.cqbarbershopapi;

import com.yjj.cqbarbershopapi.dao.VipRepository;
import com.yjj.cqbarbershopapi.entity.Vip;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.persistence.Persistence;

@SpringBootTest
class CqBarbershopApiApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串的

//    @Autowired
//    RedisTemplate redisTemplate;//k-v都是对象的

    @Autowired
    RedisTemplate<Object,Vip> vipRedisTemplate;//自定义

    @Autowired
    VipRepository vipRepository;

    @Test
    void contextLoads() {

    }

    /**
     * 测试jpa的保存
     */
    @Test
    public void testSave(){
        Persistence.createEntityManagerFactory("");
    }

    /**
     * 测试redis的连接性
     * String List Set Hash ZSet
     * stringRedisTemplate.opsForValue();[String]
     * stringRedisTemplate.opsForList();[List]
     *
     */
    @Test
    public void redisContent(){
        //String
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
        //list
//        stringRedisTemplate.opsForList().leftPush("mylist","1");
//        stringRedisTemplate.opsForList().leftPush("mylist","2");
        //对象
        Vip one = vipRepository.findById(3).get();
//        redisTemplate.opsForValue().set("emp-01",one);
        //转换序列化对象版本
        vipRedisTemplate.opsForValue().set("Vip-01",one);
    }

}
