package com.yjj.cqbarbershopapi.controller;

import com.yjj.cqbarbershopapi.entity.Vip;
import com.yjj.cqbarbershopapi.response.BaseResult;
import com.yjj.cqbarbershopapi.service.VipService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class VipController {

    @Autowired
    VipService vipService;

    @GetMapping("/vip/list")
    @ApiOperation(value = "用户列表查询")
    public Page<Vip> list(@ApiParam("当前页")String page, @ApiParam("每页显示的条数")String size, @ApiParam("用户名查询条件") String name){
        //只对name进行查询
        if (page==null){
            page="0";
        }
        if (size==null){
            size="5";
        }
        List<Vip> list = new ArrayList<>();
        Page<Vip> vips = vipService.findAll(Integer.parseInt(page), Integer.parseInt(size),name);
        return vips;
    }

    @PostMapping("/vip")
    @ApiOperation(value = "新增用户")
    public BaseResult save(Vip vip){
        vip.setBalance(new BigDecimal("0"));
        vip.setCard_no("vip000006");
        vip.setCreate_date(new Date());
        boolean save = vipService.save(vip);
        if (save){
            return new BaseResult(save,"保存成功");
        }else {
            return new BaseResult(save,"名字没有或重复");
        }
    }

    @GetMapping("/vip/{id}")
    @ApiOperation(value = "根据id查找用户")
    public Vip findById(@ApiParam("用户id") @PathVariable("id") Integer id){
        System.out.println("test:"+id);
        return vipService.findById(id);
    }

    @DeleteMapping("/vip/{ids}")
    @ApiOperation(value = "删除用户")
    public BaseResult delete(@ApiParam("用户id列表") @PathVariable("ids") String ids){
        String[] Ids = ids.split(",");
        // 将字符串数组转为List<Intger> 类型
        List<Integer> LString = new ArrayList<Integer>();
        for(String id : Ids){
            LString.add(new Integer(id));
        }
        vipService.deleteById(LString);
        return new BaseResult(true,"chenggong");
    }

    @PutMapping("/vip")
    @ApiOperation(value = "更新用户资料")
    public BaseResult update(@RequestBody Vip vip){
        System.out.println(vip);
        Vip update = vipService.update(vip);
        if (update!=null){
            return new BaseResult(true,"chenggong");
        }
        return new BaseResult(false,"id输入有误");
    }



}
