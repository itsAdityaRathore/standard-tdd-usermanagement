package com.example.Standards.Dao;

import com.example.Standards.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Users searchByUmmanagerAndUid(String umanager, int uid) throws Exception {
        Query query = entityManager.createQuery("select u from Users u where u.uManager = ?1 and u.uId = ?2");
        query.setParameter(1, umanager);
        query.setParameter(2, uid);
        if (query.getResultList().size() < 1) throw new Exception("User Not Found");
        return (Users) query.getResultList().get(0);

    }

    public String createBulkUser() throws Exception {
        List<Users> usersBulk = Arrays.asList(
                new Users("Aditya", "Udaipur", "9090909090", 1, ""),
                new Users("Mohan", "Ajmer", "9090901234", 2, "1001"),
                new Users("Amit", "Kolkata", "9093456090", 2, "1001"),
                new Users("Rahul", "Raipur", "9879609090", 3, "1002"),
                new Users("Salim", "Bikaner", "8841909090", 1, ""),
                new Users("Parul", "Chennai", "7896909090", 2, "1005"),
                new Users("Gaurav", "Himachal", "9980789090", 3, "1006"),
                new Users("Avish", "Goa", "8890656090", 3, "1006")
        );

        if (usersBulk == null) throw new Exception("Bulk data not Presesnt");

        userRepository.saveAll(usersBulk);
        return "Bulk Create Completed";
    }

    public List<Users> getUsers() throws Exception {
//        try {
//            List<Users> temp = userRepository.findAll();
//            if (temp.size() < 1) throw new Exception("No User Data Available");
//            else return temp;
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }

        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    public String createUser(Users users) throws Exception {
        userRepository.save(users);
        return "Users Created";
    }

}
