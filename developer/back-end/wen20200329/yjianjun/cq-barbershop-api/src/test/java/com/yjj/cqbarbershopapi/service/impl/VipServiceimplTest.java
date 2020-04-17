package com.yjj.cqbarbershopapi.service.impl;

import com.yjj.cqbarbershopapi.dao.VipRepository;
import com.yjj.cqbarbershopapi.entity.Vip;
import com.yjj.cqbarbershopapi.response.BaseResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VipServiceimplTest {

    @Autowired
    VipRepository vipRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Transactional
    void save() {
        Vip vip = new Vip();
        vip.setBalance(new BigDecimal("0"));
        vip.setCard_no("vip000004");
        vip.setCreate_date(new Date());
        vip.setName("dsb");
        vip.setPass("0231");
        vipRepository.save(vip);
    }

    @Test
    @Transactional
    @Rollback(true)
    void deleteById() {
        try {
            vipRepository.deleteById(1);
            BaseResult baseResult = new BaseResult(true,"chengong");
        } catch (Exception e) {
            BaseResult baseResult = new BaseResult(false,"shibai");
            e.printStackTrace();
        }
    }

    @Test
    void findById() {
        Vip vip = vipRepository.findById(1).get();
        assertNotNull(vip);
        assertEquals(vip.getId(),1);
        assertEquals(vip.getPass(),"110");
        assertEquals(vip.getTel(),"120");
    }

    @Test
    void update() {
    }
}