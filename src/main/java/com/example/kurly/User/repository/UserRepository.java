package com.example.kurly.User.repository;

import com.example.kurly.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAddress(String email, String password);

    User checkDuplicationByEmailAddress(String email);
}
