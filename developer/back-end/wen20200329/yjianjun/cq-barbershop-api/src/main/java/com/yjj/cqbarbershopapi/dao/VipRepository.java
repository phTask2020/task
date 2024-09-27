package com.yjj.cqbarbershopapi.dao;

import com.yjj.cqbarbershopapi.entity.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface VipRepository extends JpaRepository<Vip,Integer>, JpaSpecificationExecutor<Vip> {

}
