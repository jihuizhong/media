package com.example.media.controller;

import com.example.media.entity.User;
import com.example.media.service.intf.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/v2/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserList")
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @RequestMapping("set")
    public void setSession(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("userName", "Tom");
        log.info("sessionId = {}", httpSession.getId());
    }

    @RequestMapping("get")
    public void getSession(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Object object = httpSession.getAttribute("userName");
        if (object instanceof String) {
            log.info("userName: {}", object.toString());
        } else {
            log.info("userName is null");
        }

        log.info("sessionId = {}", httpSession.getId());
    }
}
