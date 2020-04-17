package com.yjj.cqbarbershopapi.dao;

import com.yjj.cqbarbershopapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface OrderRepository extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {

}
