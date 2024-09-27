package com.yjj.cqbarbershopapi.service;

import com.yjj.cqbarbershopapi.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    public Page<Order> findByPage(int page, int size, int id);

    public List<Order> findAll();

    public boolean reChange(int id,int amount);
}
