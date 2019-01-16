package com.chirq.study.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.chirq.study.business.entity.User;
import com.chirq.study.business.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("save")
    public String cancelOrder() {
        User user = new User();
        Double d = 1 * Math.random() * 10;
        int num = d.intValue();
        user.setAddress("address" + num);
        user.setAge(12);
        user.setName("jick" + num);
        user.setUserDept("dept" + num);
        userService.save(user);
        return JSONObject.toJSONString(user);
    }

    @GetMapping("delete")
    public String delete(int id) {
        userService.delete(id);
        return "ok";
    }

    @GetMapping("select")
    public String select() {
        return JSONObject.toJSONString(userService.selectAll());
    }

}
