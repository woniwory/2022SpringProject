package com.example.kurly.User.controller;

import com.example.kurly.User.dto.UserForm;
import com.example.kurly.User.entity.User;
import com.example.kurly.User.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @Slf4j
    public class UserController {
        @Autowired
        private UserService userService;

        //모든 회원 정보 가져오기
        @GetMapping("/users/getAll")
        public List<User> getAllusers(){
            return userService.getAllUsers();
        }

        //회원가입할 때, 잘 입력됐으면 정보 전송
        @PostMapping("/api/users/create")
        public ResponseEntity<User> create(@RequestBody UserForm dto){
            log.info(dto.toString());
            User created = userService.create(dto);
            return (created != null) ?
                    ResponseEntity.status(HttpStatus.OK).body(created):
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        //로그인후 MyPage로 정보 전송
        @PostMapping("/api/users/login")
        public ResponseEntity<User> login(@RequestBody UserForm dto){
            log.info(dto.toString());
            User login = userService.login(dto);
            return (login != null) ?
                    ResponseEntity.status(HttpStatus.OK).body(login):
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //이메일 중복확인-> 존재하면 true return, 비어있으면
        @PostMapping("/api/users/check/email")
        public boolean duplication(@RequestBody UserForm dto){
            User duplicated = userService.duplicate(dto);
            return (duplicated != null) ?
                    true: false;
        }

        @PatchMapping("/api/users/{useridx}/update")
        public void statusUpdate(@PathVariable Long useridx){
            User user = userService.statusUpdate(useridx);
        }

        @DeleteMapping("/api/users/{useridx}/delete")
        public void delete (@PathVariable Long useridx){
            userService.delete(useridx);
        }





    }

