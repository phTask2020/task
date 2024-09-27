package com.yjj.cqbarbershopapi.controller;


import com.yjj.cqbarbershopapi.entity.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RestTemplateController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getForObject")
    public List<Vip> getForObject(){
        String url = "http://localhost:8081/vip/list";
        List forObject = restTemplate.getForObject(url, List.class);
        return forObject;
    }

    @GetMapping("/getForEntity")
    public List<Vip> getForEntity(){
        String url = "http://localhost:8081/vip/list";
        ResponseEntity<List> forEntity = restTemplate.getForEntity(url, List.class);
        int statusCodeValue = forEntity.getStatusCodeValue();//获得状态码
        HttpHeaders headers = forEntity.getHeaders();//获得请求头
        System.out.println(statusCodeValue);
        System.out.println(headers);
        return forEntity.getBody();
    }
}
