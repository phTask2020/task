package com.yjj.cqbarbershopapi.service.impl;

import com.yjj.cqbarbershopapi.dao.OrderRepository;
import com.yjj.cqbarbershopapi.dao.VipRepository;
import com.yjj.cqbarbershopapi.entity.Order;
import com.yjj.cqbarbershopapi.entity.Vip;
import com.yjj.cqbarbershopapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class OrderServiceimpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    VipRepository vipRepository;

    @Override
    public Page<Order> findByPage(int page, int size, int id) {
        Order order = new Order();
        order.setId(id);
        PageRequest of = PageRequest.of(page, size);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("orderId")
                .withIgnorePaths("recount").withIgnorePaths("cocount")
                .withIgnorePaths("amount");
        Example<Order> of1 = Example.of(order, matcher);
        return orderRepository.findAll(of1, of);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public boolean reChange(int id, int amount) {
        Order order = new Order();
        order.setId(id);
        if (amount>=100){
            Vip vip = vipRepository.findById(id).get();
            vip.setBalance(vip.getBalance().add(new BigDecimal(amount+"")));
            vip.setCount(vip.getCount()+1);
            vipRepository.save(vip);
            order.setAmount(new BigDecimal(amount+""));
            order.setRecount(vip.getCount());
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}
