package com.course.imooc;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @Auther: 清依
 * @Date: 2022/8/30 21:04
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
