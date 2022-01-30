package com.example.kurly.Order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor  //디폴트 생성자 추가
@ToString
@Getter //모든 get을 사용가능
@Entity // DB가 해당 객체를 인식 가능!
public class Order {

    @Id // 대표값을 지정! like a 주민등록번호
    @GeneratedValue // 1, 2, 3,...자동 생성 이노테이션!
    private Long userIdx;

    @Column(length = 45, nullable = false)
    private String userID;

    @Column(length = 45, nullable = false)
    private String userPassword;

    @Column(length = 45, nullable = false)
    private String userName;

    @Column(length = 45)
    private String userEmail;

    @Column(length = 45)
    private String userPhoneNum;

    @Column(length = 45)
    private String userLocation;

    @Column(columnDefinition ="char")
    private String userGender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date userBirth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(columnDefinition ="char")
    private String status;



}
