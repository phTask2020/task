package com.yjj.cqbarbershopapi.controller;

import com.yjj.cqbarbershopapi.entity.Order;
import com.yjj.cqbarbershopapi.response.BaseResult;
import com.yjj.cqbarbershopapi.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("order")
    @ApiOperation("带条件查询充值记录")
    public Page<Order> findByPage(int page, int size, String id){
        if (id==null){
            return null;
        }
        Page<Order> byPage = orderService.findByPage(page, size, Integer.parseInt(id));
        return byPage;
    }

    @GetMapping("order/list")
    @ApiOperation("充值记录")
    public List<Order> findAll(){
        List<Order> all = orderService.findAll();
        return all;
    }

    @PutMapping("order")
    @ApiOperation("充值入口")
    public BaseResult save(@ApiParam("vip的id") int id,@ApiParam("充值金额必须大于等于100") int amount){
        boolean b = orderService.reChange(id, amount);
        if (b){
            return new BaseResult(true,"充值成功");
        }else {
            return new BaseResult(false,"充值失败");
        }
    }
}
