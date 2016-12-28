package com.common.cache.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * redis 序列化配置类
 * @auth snifferhu
 * @date 2016/12/27 22:05
 */
@Component
public class RedisConfig {

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
