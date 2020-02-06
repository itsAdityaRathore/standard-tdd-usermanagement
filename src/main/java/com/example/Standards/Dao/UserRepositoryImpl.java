package com.example.Standards.Dao;

import com.example.Standards.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    public List<Users> getUserByuManager(String uManager) {
        return userRepository.findUsersByuManager(uManager);
    }

    public Users searchByUmmanagerAndUid(String umanager, int uid) throws Exception {
        Query query = entityManager.createQuery("select u from Users u where u.uManager = ?1 and u.uId = ?2");
        query.setParameter(1, umanager);
        query.setParameter(2, uid);
        if (query.getResultList().size() < 1) throw new Exception("User Not Found");
        return (Users) query.getResultList().get(0);

    }

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

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public String createUser(Users users) {
        userRepository.save(users);
        return "Users Created";
    }

}
