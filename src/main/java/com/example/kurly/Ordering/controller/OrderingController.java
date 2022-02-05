package com.example.kurly.Ordering.controller;

import com.example.kurly.Ordering.entity.Ordering;

import com.example.kurly.Ordering.dto.OrderingForm;
import com.example.kurly.Ordering.service.OrderingService;
import com.example.kurly.Ordering.entity.Ordering;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderingController{
    @Autowired
    private OrderingService orderingService;

    //모든 회원 정보 가져오기
    @GetMapping("/order/getAll")
    public List<Ordering> getAllOrderings(){
        return orderingService.getAllOrderings();
    }

    //회원가입할 때, 잘 입력됐으면 정보 전송
    @PostMapping("/api/order/create")
    public ResponseEntity<Ordering> create(@RequestBody OrderingForm dto){
        log.info(dto.toString());
        Ordering created = orderingService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/ordering/{orderingidx}/update")
    public void statusUpdate(@PathVariable Long orderingidx){
        Ordering Ordering = orderingService.statusUpdate(orderingidx);
    }

    @DeleteMapping("/api/ordering/{orderingidx}/delete")
    public void delete (@PathVariable Long orderingidx){
        orderingService.delete(orderingidx);
    }
   

}

