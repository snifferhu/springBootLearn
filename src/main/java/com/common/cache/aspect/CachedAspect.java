package com.common.cache.aspect;

import com.common.cache.annotation.Cached;
import com.common.invoke.InvokeTool;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 写value缓存注解配置
 * @auth snifferhu
 * @date 2016/12/26 21:28
 */
@Aspect
@Component
public class CachedAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private InvokeTool tool;

    @Pointcut("@annotation(com.common.cache.annotation.Cached)")
    public void afterReturningCache() {
    }

    @Around(value = "@annotation(com.common.cache.annotation.Cached)",argNames = "id")
    public void around(Long id){

    }

    @AfterReturning(pointcut = "afterReturningCache()",returning = "returnValue")
    public void cache(JoinPoint joinPoint, Object returnValue) throws Throwable {
        Object[] tmp = joinPoint.getArgs();
        Object targetValue = Optional.ofNullable(tmp).orElseThrow(() -> {
            logger.debug("@cache method is miss args! method={}", tool.getMethod(joinPoint));
            return new RuntimeException(String.format("@cache method is miss args! method={}", tool.getMethod(joinPoint)));
        })[0];
        Cached cached = (Cached) tool.getAnnotation(joinPoint, Cached.class);
        String key = cached.key() + targetValue;
        redisTemplate.opsForValue().set(key, returnValue);
    }
}
