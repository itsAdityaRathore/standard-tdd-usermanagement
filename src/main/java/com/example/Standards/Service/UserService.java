package com.example.Standards.Service;

import com.example.Standards.Model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    String createBulkUser();

    List<Users> getUsers();

    String createUser(Users users);

    List<Users> getUserByUmanager(String uManager);

    Users getUserByUmanagerAndUid(String umanager, int uid) throws Exception;
}
