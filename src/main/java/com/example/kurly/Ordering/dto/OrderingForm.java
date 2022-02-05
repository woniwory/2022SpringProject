package com.example.kurly.Ordering.dto;

import com.example.kurly.Ordering.entity.Ordering;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
public class OrderingForm {

    private Long basketIdx;
    private Long productIdx;
    private Long count;
    private Long totalPrice;
    private Long deliveryPrice;
    private Date createdAt;
    private Date updatedAt;
    private String status;


    public Ordering toEntity() {
        return new Ordering(null, basketIdx, productIdx, count, totalPrice, deliveryPrice
        ,createdAt,updatedAt,status);
    }

}


