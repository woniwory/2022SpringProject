package com.example.kurly.Ordering.service;
/*서비스 함수 구현*/


import com.example.kurly.Ordering.dto.OrderingForm;
import com.example.kurly.Ordering.entity.Ordering;
import com.example.kurly.Ordering.repository.OrderingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class OrderingService {
    @Autowired
    private OrderingRepository orderingRepository;
    //전체 ordering조회 함수
    public List<Ordering> getAllOrderings() {
        return orderingRepository.findAll();
    }
    public Ordering check(Long id){
        Ordering target = orderingRepository.findById(id).orElse(null);
        if(target==null){
            return null;
        }
        orderingRepository.save(target);
        log.info(target.toString()); //db에 저장된 객체를 찍어보기
        return target;
    }
    //ordering생성
    public Ordering create(OrderingForm dto) {
        Ordering ordering = dto.toEntity();
        if(ordering.getOrderingIdx() != null){
            return null;
        }
        return orderingRepository.save(ordering);
    }
    public Ordering statusUpdate(Long orderingidx){
        Ordering target = orderingRepository.findById(orderingidx).orElse(null);
        target.setStatus("N");
        return orderingRepository.save(target);
    }

    public void delete(Long orderingidx){
        Ordering target = orderingRepository.findById(orderingidx).orElse(null);

        if (target != null){
            orderingRepository.delete(target);
        }
    }
}




