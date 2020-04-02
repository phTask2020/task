package com.ph.springbootcacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootcacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcacheRedisApplication.class, args);
    }

}
