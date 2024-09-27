package com.yjj.cqbarbershopapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("订单id")
    private Integer orderId;
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("充值总次数")
    private int recount;
    @ApiModelProperty("消费总次数")
    private int cocount;
    @ApiModelProperty("充值金额")
    private BigDecimal amount;
}
