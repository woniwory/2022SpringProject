package com.example.kurly.Ordering.repository;

import com.example.kurly.Ordering.entity.Ordering;
import com.example.kurly.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingRepository extends JpaRepository<Ordering, Long> {

}
