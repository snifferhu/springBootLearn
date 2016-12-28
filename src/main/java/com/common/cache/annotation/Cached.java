package com.common.cache.annotation;

import java.lang.annotation.*;

/**
 * @// TODO: 2016/12/18 规划缓存注解,将简单缓存操作迁移至注解完成
 * @auth snifferhu
 * @date 2016/12/18 11:37
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cached {
    String key();
}
