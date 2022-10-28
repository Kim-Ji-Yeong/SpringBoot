package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/user")
    public String add(@RequestBody User user) {
        userDao.add(user);
        return String.format("%s번에 정보가 등록되었습니다.", user.getId());
    }

    @DeleteMapping(value = "/user/{id}")
    public String deleteById(@PathVariable String id) {
        userDao.deleteById(id);
        return String.format("%s번의 정보가 삭제되었습니다.", id);
    }

    @DeleteMapping(value = "/user/all")
    public String deleteAll() {
        userDao.deleteAll();
        return "모든 정보가 삭제되었습니다.";
    }
}