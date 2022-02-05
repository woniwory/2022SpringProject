package com.example.kurly.User.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userIdx")
    private Long userIdx;

    @Column(name = "userID", length = 45, nullable = false)
    private String userID;

    @Column(name = "userPassword",length = 45, nullable = false)
    private String userPassword;

    @Column(name = "userName", length = 45, nullable = false)
    private String userName;

    @Column(name = "userEmail",length = 45)
    private String userEmail;

    @Column(name = "userPhoneNum",length = 45)
    private String userPhoneNum;

    @Column(name = "userLocation",length = 45)
    private String userLocation;

    @Column(name = "userGender",columnDefinition ="char")
    private String userGender;

    //@Temporal(TemporalType.TIMESTAMP)
    //@ColumnDefault("0") //default 0

    @Column(name = "userBirth",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date userBirth;


//    @Temporal(TemporalType.TIMESTAMP)
//    @ColumnDefault("0") //default 0

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
