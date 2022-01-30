package com.example.kurly.Order.dto;

import com.example.kurly.User.entity.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
public class OrderForm {
private String userID;
private String userPassword;
private String userName;
private String userEmail;
private String userPhoneNum;
private String userLocation;
private String userGender;
private Date userBirth;
private Date createdAt;
private Date updatedAt;
private String status;



    public User toEntity() {
        return new User(null, userID, userPassword, userName, userEmail, userPhoneNum
        , userLocation, userGender, userBirth, createdAt, updatedAt, status);
    }

}


