package com.course.imooc.system.controller;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @Auther: 李清依
 * @Date: 2022/10/6 16:17
 * @Description:
 */
public class main {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void print(){
        redisTemplate.opsForValue().set("num","123");
        System.out.println(redisTemplate.opsForValue().get("num"));;
    }


}
