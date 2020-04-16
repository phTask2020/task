package com.reuben.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;



@ApiModel(value = "User对象", description = "用户对象user")
@Component
@ConfigurationProperties(prefix = "user")
@Validated
@Data
/**get,set方法*/
@AllArgsConstructor
/**全参构造*/
@NoArgsConstructor
/**无参构造*/
/**jpa*/
@Entity
/**标注实体类*/
@Table(name = "tb_user")
/**
 * @author Circle_clearly
 */
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
/**主键自增*/
    @Column(name = "id")
    @ApiModelProperty(value = "userId", hidden = false)
    private Integer userId;

    @ApiModelProperty(value = "用户名", name = "userName", example = "reuben")
    @NotBlank
    @Column(name = "user_name")
    private String userName;


    @ApiModelProperty(value = "密码", name = "userPassword", example = "reuben")
    @NotBlank
    @Column(name = "user_password")
    private String userPassword;

    @ApiModelProperty(value = "邮箱", name = "email", example = "reuben@mail.com")
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "isdel")
    @ApiModelProperty(value = "逻辑删除，默认0", name = "isdel", example = "0", hidden = false)
    /**是否删除:1删除，0未删除*/
    private String del;


    public User(@NotBlank String userName, @NotBlank String userPassword, @NotBlank @Email String email) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
        /**默认0，未被删除*/
        this.del = "0";
    }
}
