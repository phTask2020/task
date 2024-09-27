package com.example.grpcclient.controller;

import com.example.grpcclient.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @GetMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Michael") String name) {
        return grpcClientService.sendMessage(name);
    }
}
