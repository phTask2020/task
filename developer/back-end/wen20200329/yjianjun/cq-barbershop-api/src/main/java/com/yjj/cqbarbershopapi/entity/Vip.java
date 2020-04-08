package com.yjj.cqbarbershopapi.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "t_vip")
public class Vip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户id")
    private Integer id;
    @ApiModelProperty(value = "用户名")
    private String name;
    @ApiModelProperty(value = "用户电话")
    private String tel;
    @ApiModelProperty(value = "用户余额")
    private BigDecimal balance;
    @ApiModelProperty(value = "用户卡号")
    private String card_no;
    @ApiModelProperty(value = "用户密码")
    private String pass;
    @ApiModelProperty(value = "用户创建时间")
    private Date create_date;
    @ApiModelProperty(value = "用户充值次数")
    private int count;


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getTel() {
//        return tel;
//    }
//
//    public void setTel(String tel) {
//        this.tel = tel;
//    }
//
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//
//    public String getCard_no() {
//        return card_no;
//    }
//
//    public void setCard_no(String card_no) {
//        this.card_no = card_no;
//    }
//
//    public String getPass() {
//        return pass;
//    }
//
//    public void setPass(String pass) {
//        this.pass = pass;
//    }
//
//    public Date getCreate_date() {
//        return create_date;
//    }
//
//    public void setCreate_date(Date create_date) {
//        this.create_date = create_date;
//    }
}
