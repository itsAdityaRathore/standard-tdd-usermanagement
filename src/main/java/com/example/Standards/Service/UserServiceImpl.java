package com.example.Standards.Service;

import com.example.Standards.Dao.UserRepository;
import com.example.Standards.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String createBulkUser() throws Exception {
        return userRepository.createBulkUser();
    }

    @Override
    public List<Users> getUsers() throws Exception {
        return userRepository.getUsers();
    }

    @Override
    public String createUser(Users users) throws Exception {
        return userRepository.createUser(users);
    }

    @Override
    public List<Users> getUserByUmanager(String uManager) throws Exception {
        return userRepository.findUsersByuManager(uManager);
    }

    @Override
    public Users getUserByUmanagerAndUid(String umanager, int uid) throws Exception {
        return userRepository.searchByUmmanagerAndUid(umanager, uid);
    }
}
