package com.example.kurly.User.repository;

import com.example.kurly.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    ArrayList<User> findAll();

    @Query("select u from User u where u.userEmail = :userEmail and u.userPassword= :userPassword")
    User findByEmailAddress(@Param("userEmail") String userEmail,
                            @Param("userPassword") String userPassword);
    @Query("select u from User u where u.userEmail = :userEmail")
    User checkDuplicationByEmailAddress(@Param("userEmail") String userEmail);


}
