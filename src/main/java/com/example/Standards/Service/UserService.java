package com.example.Standards.Service;

import com.example.Standards.Model.Users;

import java.util.List;

public interface UserService {

    String createBulkUser() throws Exception;

    List<Users> getUsers() throws Exception;

    String createUser(Users users) throws Exception;

    List<Users> getUserByUmanager(String uManager) throws Exception;

    Users getUserByUmanagerAndUid(String umanager, int uid) throws Exception;
}
