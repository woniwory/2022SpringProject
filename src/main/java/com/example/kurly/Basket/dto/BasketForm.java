package com.example.kurly.Basket.dto;

import com.example.kurly.Basket.entity.Basket;
import com.example.kurly.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@ToString
public class BasketForm {
    private Long basketIdx;
    private Long userIdx;
    private Long productIdx;
    private Date createdAt;
    private Date updatedAt;
    private String status;



    public Basket toEntity() {
        return new Basket(null, userIdx, productIdx, createdAt, updatedAt, status);
    }

}


