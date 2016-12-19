package com.demo.service;

import com.demo.controller.bean.User;

import java.util.List;

/**
 * @auth snifferhu
 * @date 2016/12/18 14:22
 */
public interface UserService {
    /**
     * 获取用户列表
     */
    List<User> getUserList();
}
