package com.example.kurly.User.service;
/*서비스 함수 구현*/


import com.example.kurly.User.dto.UserForm;
import com.example.kurly.User.entity.User;
import com.example.kurly.User.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserService{
    @Autowired
    private UserRepository userRepository;
    //전체 USER조회 함수
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User check(Long id){
        User target = userRepository.findById(id).orElse(null);
        if(target==null){
            return null;
        }
        userRepository.save(target);
        log.info(target.toString()); //db에 저장된 객체를 찍어보기
        return target;
    }
    //user생성
    public User create(UserForm dto) {
        User user = dto.toEntity();
        if(user.getUserID() != null){
            return null;
        }
        return userRepository.save(user);
    }
    //로그인
    public User login(UserForm dto) {
        User user = dto.toEntity(); //사용자가 입력한 정보를 갖는 객체
        User login = userRepository.findByEmailAddress(user.getUserEmail(), user.getUserPassword()); //이메일을 건내서 해당 객체 반환
        if(login==null){
            return null;
        }
        return login;
    }
    public User duplicate(UserForm dto){
        User user=dto.toEntity();
        User check = userRepository.checkDuplicationByEmailAddress(user.getUserEmail());
        if(check==null){
            return null;
        }
        return check;
    }

    public User statusUpdate(Long useridx){
        User target = userRepository.findById(useridx).orElse(null);
        target.setStatus("N");
        return userRepository.save(target);
    }

    public void delete(Long useridx){
        User target = userRepository.findById(useridx).orElse(null);

        if (target != null){
            userRepository.delete(target);
        }
    }
}