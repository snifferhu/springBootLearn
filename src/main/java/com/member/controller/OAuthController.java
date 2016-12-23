package com.member.controller;

import com.member.controller.bean.Member;
import com.member.controller.bean.MemberBuilder;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录鉴权管理
 * @auth snifferhu
 * @date 2016/12/22 20:02
 */
@RestController
@RequestMapping(value = "/oauth")
public class OAuthController {
    private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);

    private static Map<Long,Member> members = new HashMap<Long,Member>(){{
        put(1L,new MemberBuilder().setId(1L).setEmail("1@gl.com").setName("1").setPassword("111111").setPhone("13320788580").createMember());
        put(2L,new MemberBuilder().setId(2L).setEmail("1@gl.com").setName("2").setPassword("222222").setPhone("13320788580").createMember());
        put(3L,new MemberBuilder().setId(3L).setEmail("1@gl.com").setName("3").setPassword("333333").setPhone("13320788580").createMember());
    }};

    @ApiOperation(value = "登录鉴权", notes = "根据name && password,鉴权用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "member",value = "用户鉴权实体member",required = true,dataType = "Member")
    })
    @PostMapping
    public String login(@RequestBody Member member){
        if (member == null){
            return "fail";
        }
        Member target = members.get(member.getId());
        if (target != null &&
                target.getName().equals(member.getName()) &&
                target.equals(member.getPassword())) {
            return "success";
        }
        return "fail";
    }
}
