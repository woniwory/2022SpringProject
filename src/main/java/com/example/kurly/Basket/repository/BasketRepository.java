package com.example.kurly.Basket.repository;

import com.example.kurly.Basket.entity.Basket;
import com.example.kurly.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
