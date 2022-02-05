package com.example.kurly.Basket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Basket {

    @Id
    @GeneratedValue
    @Column(name = "basketIdx")
    private Long basketIdx;

    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "productIdx")
    private Long productIdx;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    //    @Temporal(TemporalType.TIMESTAMP)
//    @ColumnDefault("0") //default 0
    @Column(name = "updatedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

    @Column(name = "status",columnDefinition ="char")
    @ColumnDefault("'Y'")
    private String status;



}
