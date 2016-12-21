package com.demo.controller;

import com.demo.controller.bean.User;
import com.demo.controller.bean.UserBuilder;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auth snifferhu
 * @date 2016/12/18 14:18
 * @value 本以为RestController注解, value字段可以用作mapping, 然而不是。
 * 结果查看了注解之后,发觉它只是集成了以前的controller注解跟responsebody注解。
 * value则只是这个controller作为java bean,在spring 中的引用名或者说组件名;
 * The value may indicate a suggestion for a logical component name,
 * to be turned into a Spring bean in case of an autodetected component.
 */
@RestController("/users")
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private static Map<Long, User> users = new HashMap<Long, User>() {
        {
            put(1L, new UserBuilder().setId(1L).setName("小鸭").setAge(23).createUser());
            put(2L, new UserBuilder().setId(2L).setName("小鸡").setAge(22).createUser());
            put(3L, new UserBuilder().setId(3L).setName("小鹅").setAge(24).createUser());
        }
    };

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping
    public List<User> getUserList() {
        return users.values().stream().collect(Collectors.toList());
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping(value = "/{id}")
    public String updateUser(@PathVariable Long id,@Valid @RequestBody User user) {
        if (!users.containsKey(id)) {
            logger.warn("update user failed ,id:{} ,user:{}", id, user);
            return "fail";
        }
        User tmp = users.get(id);
        BeanUtils.copyProperties(user, tmp);
        tmp.setId(id);
        return "success";
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping
    public String addUser(@Valid @RequestBody User user) {
        if (user != null && users.containsKey(user.getId())) {
            logger.warn("add user fail,user:{}", user);
            return "fail";
        }
        User result = users.put(user.getId(), user);
        logger.info("add user:{}", result);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (!users.containsKey(id)) {
            logger.warn("delete user failed, id:{}", id);
            return "fail";
        }
        User result = users.remove(id);
        logger.info("delete user:{}", result);
        return "success";
    }
}
