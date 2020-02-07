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
    public String createBulk() throws Exception {
        return userService.createBulkUser();
    }

    @GetMapping("/users")
    private List<Users> getUsers() throws Exception {
        return userService.getUsers();
    }

    @PostMapping("/users/new")
    public String createUser(@RequestBody Users users) throws Exception {
        return userService.createUser(users);
    }

    @GetMapping("/users/{uManager}")
    public List<Users> getUserByManager(@PathVariable("uManager") String uManager) throws Exception {
        return userService.getUserByUmanager(uManager);
    }

    @GetMapping("/users/{uid}/umanager/{umanager}")
    public Users getUserByUmanagerAndUid(
            @PathVariable("umanager") String umanager,
            @PathVariable("uid") int uid) throws Exception {
        return userService.getUserByUmanagerAndUid(umanager, uid);
    }
}
