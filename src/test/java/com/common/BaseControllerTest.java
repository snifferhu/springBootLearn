package com.common;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @auth snifferhu
 * @date 2016/12/20 22:09
 */
@AutoConfigureMockMvc
public class BaseControllerTest extends BaseTest {
    protected MockMvc mvc;
}
