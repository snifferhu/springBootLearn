package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @auth snifferhu
 * @date 2016/12/27 00:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration
public class ApplicationTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test() throws Exception {
        redisTemplate.opsForValue().set("a", "1");
        assertEquals("1", redisTemplate.opsForValue().get("a"));
        logger.debug("cached:{}",redisTemplate.opsForValue().get("a"));
    }
}