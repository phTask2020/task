package com.reuben.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**配置Swagger信息apiInfo*/
    private ApiInfo apiInfo(){
        Contact contact = new Contact("reuben", "https://github.com/ReubenYm/", "yuanmaooooo@gmail.com");
        return new ApiInfo(
                "reuben的SwaggerApi",
                "入门Swagger",
                "1.3",
                "https://github.com/ReubenYm/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

    }
    /**配置了Swagger的Docket的bean实例*/
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //enable:是否启动Swagger,如果为false则Swagger不能在浏览器中访问
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.reuben.controller"))
                //path():过滤什么路径
                //.paths(PathSelectors)
                .build();
    }
}
