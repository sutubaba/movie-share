package com.sutu.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: renc
 * @2020/5/27
 * @description:
 **/
@Data
@Table(name = "movie_person")
@ApiModel(value = "电影相关人物")
public class MoviePerson {

    @ApiModelProperty(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    @Column(name = "person_name")
    private String personName;

    @ApiModelProperty(value = "描述")
    @Column(name = "person_description")
    private String personDescription;

    @ApiModelProperty(value = "出生日期")
    @Column(name = "birthday")
    private Date birthday;

}
