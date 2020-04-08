package com.reuben.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author reuben
 * @program: springboot_demo
 * @description: params for page
 * @create: 2020-03-20 18:36
 **/
@ApiModel(value = "PageParam分页查询参数对象", description = "无条件时，参数留空（需要id查询请使用findByUserId)")
@Component
@Data
/**get,set方法*/
@AllArgsConstructor
/**全参构造*/
@NoArgsConstructor
/**无参构造*/
public class PageParam implements Serializable {
    private User user;
    @ApiModelProperty(value = "页码", name = "pageNum", example = "0")
    private Integer pageNum;
    @ApiModelProperty(value = "每页显示条数", name = "pageSize", example = "5")
    private Integer pageSize;

}
