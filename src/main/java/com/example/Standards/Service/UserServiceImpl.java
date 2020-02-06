package com.example.Standards.Service;

import com.example.Standards.Dao.UserRepository;
import com.example.Standards.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String createBulkUser() {
        List<Users> usersBulk = Arrays.asList(
                new Users("Aditya", "Udaipur", "9090909090", "AM", ""),
                new Users("Mohan", "Ajmer", "9090901234", "SM", "1001"),
                new Users("Amit", "Kolkata", "9093456090", "SM", "1001"),
                new Users("Rahul", "Raipur", "9879609090", "LP", "1002"),
                new Users("Salim", "Bikaner", "8841909090", "AM", ""),
                new Users("Parul", "Chennai", "7896909090", "SM", "1005"),
                new Users("Gaurav", "Himachal", "9980789090", "LP", "1006"),
                new Users("Avish", "Goa", "8890656090", "LP", "1006")
        );

        userRepository.saveAll(usersBulk);
        return "Bulk Create Completed";
    }

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(Users users) {
        userRepository.save(users);
        return "Users Created";
    }
}
