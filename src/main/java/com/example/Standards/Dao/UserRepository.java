package com.example.Standards.Dao;

import com.example.Standards.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>, UserRepositoryCustom {

    List<Users> findUsersByuManager(String uManager) throws Exception;

}

