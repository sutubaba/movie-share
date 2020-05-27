package com.sutu.web.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Data
public class UserDto {

    private String username;

    private String password;

    private String phone;

    private String address;

    private Date createDate;

    private String company;

    private String type;

}
