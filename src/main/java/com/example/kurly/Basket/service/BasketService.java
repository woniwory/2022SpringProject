package com.example.kurly.Basket.service;
/*서비스 함수 구현*/


import com.example.kurly.Basket.dto.BasketForm;
import com.example.kurly.Basket.entity.Basket;
import com.example.kurly.Basket.repository.BasketRepository;

import com.example.kurly.Basket.entity.Basket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;
    //전체 Basket조회 함수
    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }
    public Basket check(Long id){
        Basket target = basketRepository.findById(id).orElse(null);
        if(target==null){
            return null;
        }
        basketRepository.save(target);
        log.info(target.toString()); //db에 저장된 객체를 찍어보기
        return target;
    }
    //Basket생성
    public Basket create(BasketForm dto) {
        Basket Basket = dto.toEntity();
        if(Basket.getBasketIdx() != null){
            return null;
        }
        return basketRepository.save(Basket);
    }

    public Basket statusUpdate(Long basketidx){
        Basket target = basketRepository.findById(basketidx).orElse(null);
        target.setStatus("N");
        return basketRepository.save(target);
    }

    public void delete(Long basketidx){
        Basket target = basketRepository.findById(basketidx).orElse(null);

        if (target != null){
            basketRepository.delete(target);
        }
    }

}