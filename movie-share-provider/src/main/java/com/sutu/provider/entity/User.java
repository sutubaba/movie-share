package com.sutu.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@ApiModel(value = "用户实体")
@Entity
@Table(name = "user")
@Data
public class User {

    @ApiModelProperty(value = "用户id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ApiModelProperty(value = "手机号")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "地址")
    @Column(name = "address")
    private String address;

    @ApiModelProperty(value = "创建日期")
    @Column(name = "create_date")
    private Date createDate;

    @ApiModelProperty(value = "公司信息")
    @Column(name = "company")
    private String company;

    @ApiModelProperty(value = "用户类型")
    @Column(name = "type")
    private String type;

}
