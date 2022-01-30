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
    private Long basketIdx;

    @Column(length = 45, nullable = false)
    private String userIdx;

    @Column(length = 45, nullable = false)
    private String productIdx;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    //    @Temporal(TemporalType.TIMESTAMP)
//    @ColumnDefault("0") //default 0
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

    @Column(columnDefinition ="char")
    @ColumnDefault("'Y'")
    private String status;



}
