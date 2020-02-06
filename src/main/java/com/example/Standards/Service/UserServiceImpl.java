package com.example.Standards.Service;

import com.example.Standards.Dao.UserRepository;
import com.example.Standards.Dao.UserRepositoryImpl;
import com.example.Standards.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepositoryImpl userRepository;

    @Override
    public String createBulkUser() {
        return userRepository.createBulkUser();
    }

    @Override
    public List<Users> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public String createUser(Users users) {
        return userRepository.createUser(users);

    }

    @Override
    public List<Users> getUserByUmanager(String uManager) {
        return userRepository.getUserByuManager(uManager);
    }

    @Override
    public Users getUserByUmanagerAndUid(String umanager, int uid) throws Exception {
        return userRepository.searchByUmmanagerAndUid(umanager, uid);
    }


}
