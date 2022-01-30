package com.example.kurly.User.entity;

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
public class User {

    @Id
    @GeneratedValue
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

    //@Temporal(TemporalType.TIMESTAMP)
    //@ColumnDefault("0") //default 0

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date userBirth;


//    @Temporal(TemporalType.TIMESTAMP)
//    @ColumnDefault("0") //default 0

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
