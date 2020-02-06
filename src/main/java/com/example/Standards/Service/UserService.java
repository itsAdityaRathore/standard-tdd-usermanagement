package com.example.Standards.Service;

import com.example.Standards.Model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    String createBulkUser();

    List<Users> getUsers();

    String createUser(Users users);
}
