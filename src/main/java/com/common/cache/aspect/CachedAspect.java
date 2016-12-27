package com.common.cache.aspect;

import com.demo.controller.bean.User;
import com.demo.controller.bean.UserBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @auth snifferhu
 * @date 2016/12/26 21:28
 */
@Aspect
@Component
public class CachedAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("@annotation(com.common.cache.annotation.Cached)")
    public void cache() {
    }

    @After("cache()")
    public void cache(JoinPoint joinPoint) throws Throwable {
        Object[] tmp = joinPoint.getArgs();
//        joinPoint.getSignature().get
//        Optional.ofNullable(tmp).ifPresent();
        if (tmp.length != 0)
        redisTemplate.opsForValue().set("a",new UserBuilder().setName("a").createUser());
        User aa = (User)redisTemplate.opsForValue().get("a");
    }
}
