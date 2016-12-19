package com.demo.controller;

import com.demo.controller.bean.User;
import com.demo.controller.bean.UserBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auth snifferhu
 * @date 2016/12/18 14:18
 * @value 本以为RestController注解,value字段可以用作mapping,然而不是。
 *        结果查看了注解之后,发觉它只是集成了以前的controller注解跟responsebody注解。
 *        value则只是这个controller作为java bean,在spring 中的引用名或者说组件名;
 *        The value may indicate a suggestion for a logical component name,
 *        to be turned into a Spring bean in case of an autodetected component.
 */
@RestController("/users")
@RequestMapping(value="/users")
public class UserController {
    private static Map<Long,User> users = ImmutableMap
            .<Long,User>builder()
            .put(1L, new UserBuilder().setId(1L).setName("小鸭").setAge(23).createUser())
            .put(2L, new UserBuilder().setId(2L).setName("小鸡").setAge(22).createUser())
            .put(3L, new UserBuilder().setId(3L).setName("小鹅").setAge(24).createUser())
            .build();

    @GetMapping
    public List<User> getUserList(){
        return users.values().stream().collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id){
        return users.get(id);
    }

    @PutMapping(value = "/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user){
        if (users.containsKey(id)){
            return "fail";
        }
        User tmp = users.get(id);
        BeanUtils.copyProperties(user,tmp);
        return "success";
    }


}
