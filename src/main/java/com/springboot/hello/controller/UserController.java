package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import com.springboot.hello.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserDao userDao = null;

    public UserController(UserDao userDao) throws SQLException {
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping("/user")
    public User addAndGet() throws SQLException {
        userDao.add(new User("1", "Seoyi", "6415"));
        return userDao.findByID("2");
    }
    @DeleteMapping("/user")
    public ResponseEntity<Integer> deleteAll(){
        return ResponseEntity.ok().body(userDao.deleteAll());
    }
}