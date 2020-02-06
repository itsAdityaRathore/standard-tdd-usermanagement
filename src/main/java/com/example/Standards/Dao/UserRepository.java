package com.example.Standards.Dao;

import com.example.Standards.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    List<Users> findUsersByuManager(String uManager);

}

