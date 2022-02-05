package com.example.kurly.Ordering.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor  //디폴트 생성자 추가
@ToString
@Getter //모든 get을 사용가능
@Entity // DB가 해당 객체를 인식 가능!
public class Ordering {

    @Id // 대표값을 지정! like a 주민등록번호
    @GeneratedValue // 1, 2, 3,...자동 생성 이노테이션!
    @Column(name = "orderingIdx")
    private Long orderingIdx;

    @Column(name = "basketIdx")
    private Long basketIdx;

    @Column(name = "productIdx")
    private Long productIdx;

    @Column(name = "count")
    private Long count;

    @Column(name = "totalPrice")
    private Long totalPrice;

    @Column(name = "deliveryPrice")
    private Long deliveryPrice;

    @Column(name = "createdAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    //    @Temporal(TemporalType.TIMESTAMP)
//    @ColumnDefault("0") //default 0
    @Column(name = "updatedAt",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

    @Column(name = "status",columnDefinition ="char")
    @ColumnDefault("'Y'")
    private String status;

}
