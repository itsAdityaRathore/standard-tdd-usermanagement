package com.example.Standards.Controller;


import com.example.Standards.Model.Users;
import com.example.Standards.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/users-bulk")
    public String createBulk() {
        return userService.createBulkUser();
    }

    @GetMapping("/users")
    private List<Users> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users/new")
    public String createUser(@RequestBody Users users) {
        return userService.createUser(users);
    }
}