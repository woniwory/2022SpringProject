package com.example.kurly.Basket.controller;

import com.example.kurly.Basket.dto.BasketForm;
import com.example.kurly.Basket.entity.Basket;
import com.example.kurly.Basket.service.BasketService;
import com.example.kurly.Basket.entity.Basket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
public class BaksetController {
    @Autowired
    private BasketService basketService;

    //모든 회원 정보 가져오기
    @GetMapping("/Baskets/getAll")
    public List<Basket> getAllBaskets(){
        return basketService.getAllBaskets();
    }

    //회원가입할 때, 잘 입력됐으면 정보 전송
    @PostMapping("/api/Baskets/create")
    public ResponseEntity<Basket> create(@RequestBody BasketForm dto){
        log.info(dto.toString());
        Basket created = basketService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/Baskets/{Basketidx}/update")
    public void statusUpdate(@PathVariable Long Basketidx){
        Basket Basket = basketService.statusUpdate(Basketidx);
    }

    @DeleteMapping("/api/Baskets/{Basketidx}/delete")
    public void delete (@PathVariable Long Basketidx){
        basketService.delete(Basketidx);
    }


}

