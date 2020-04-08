package com.yjj.cqbarbershopapi.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Entity:声明实体类
 * @Table(name = "cst_customer")：实体类和表的映射
 * 用户的实体类
 */
@Entity
@Getter
@Setter
@Data
@Table(name = "cst_customer")
public class Customer {

    @Id  //声明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //配置主键的生成策略
    @Column(name = "cust_id") //属性与字段的映射
    private Long custId;//主键

    @Column(name = "cust_name")
    private String custName;//名称

    @Column(name = "cust_source")
    private String custSource;//来源

    @Column(name = "cust_level")
    private String custLevel;//级别

    @Column(name = "cust_industry")
    private String custIndustry;//所属行业

    @Column(name = "cust_phone")
    private String custPhone;//联系方式

    @Column(name = "cust_address")
    private String custAddress;//地址
}
