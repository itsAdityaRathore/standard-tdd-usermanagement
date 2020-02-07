package com.example.Standards.Dao;

import com.example.Standards.Model.Users;

import java.util.List;

public interface UserRepositoryCustom {

   String createBulkUser() throws Exception;

   List<Users> getUsers() throws Exception;

   String createUser(Users users) throws Exception;

   Users searchByUmmanagerAndUid(String umanager, int uid) throws Exception;
}
