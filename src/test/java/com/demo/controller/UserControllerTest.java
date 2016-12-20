package com.demo.controller;

import com.common.BaseControllerTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @auth snifferhu
 * @date 2016/12/20 22:07
 */

public class UserControllerTest extends BaseControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
    // 测试UserController
    private static RequestBuilder request = null;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @After
    public void tearDown() throws Exception {
        mvc = null;
    }

    @Test
    public void getUserList() throws Exception {
        // 1、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(notNullValue()));
    }

    @Test
    public void getUserById() throws Exception {
        // 2、get一个id为1的user
        request = get("/users/2");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":2,\"name\":\"小鸡\",\"age\":22}")));
    }

    @Test
    public void updateUser() throws Exception {
        // 3、put修改id为1的user
        request = put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"小鹿\",\"age\":30}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void addUser() throws Exception {
        // 4、post提交一个user
        request = post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":6,\"name\":\"小菜\",\"age\":23}");
        mvc.perform(request)
				.andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void deleteUser() throws Exception {
        // 5、del删除id为1的user
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
    }
}