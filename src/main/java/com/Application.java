package com;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Sniff on 2016/10/29.
 */
@SpringBootApplication
@EnableScheduling
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("starting spring boot ...");
        SpringApplication.run(Application.class, args);
        logger.info("everything is started.");
    }

    @Bean
    @Primary
    RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory rcf) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(rcf);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JsonRedisSerializer());

        return template;
    }

    static class JsonRedisSerializer implements RedisSerializer<Object> {

        private final ObjectMapper om;

        public JsonRedisSerializer() {
            this.om = new ObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        }

        @Override
        public byte[] serialize(Object t) throws SerializationException {
            try {
                return om.writeValueAsBytes(t);
            } catch (JsonProcessingException e) {
                throw new SerializationException(e.getMessage(), e);
            }
        }

        @Override
        public Object deserialize(byte[] bytes) throws SerializationException {

            if(bytes == null){
                return null;
            }

            try {
                return om.readValue(bytes, Object.class);
            } catch (Exception e) {
                throw new SerializationException(e.getMessage(), e);
            }
        }
    }
}