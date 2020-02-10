package com.example.Standards.Controller;


import com.example.Standards.Mapper.UsersDTO;
import com.example.Standards.Mapper.UsersMapper;
import com.example.Standards.Model.Users;
import com.example.Standards.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/users-bulk")
    public String createBulk() throws Exception {
        return userService.createBulkUser();
    }

    @GetMapping("/users")
    private List<UsersDTO> getUsers() throws Exception {

        List<Users> usr = userService.getUsers();

        // List<UsersDTO> usrdto = usr.stream().map(UsersDTO::valueOf).collect(Collectors.toList());

        List<UsersDTO> userDTO = usr.stream().map(UsersMapper.INSTANCE::usersToUsersDTO).collect(Collectors.toList());
        return userDTO;
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
        UsersDTO usersDTO = UsersMapper.INSTANCE.usersToUsersDTO(userService.getUserByUmanagerAndUid(umanager, uid));
        System.out.println(usersDTO);
        return userService.getUserByUmanagerAndUid(umanager, uid);
    }
}
