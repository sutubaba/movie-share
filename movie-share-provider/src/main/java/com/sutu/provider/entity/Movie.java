package com.sutu.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: renc
 * @2020/5/27
 * @description:
 **/
@ApiModel(value = "电影实体")
@Data
@Table(name = "movie")
public class Movie {

    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "电影名")
    @Column(name = "movie_title")
    private String movieTitle;

    @ApiModelProperty(value = "描述")
    @Column(name = "movie_description")
    private String movieDescription;

    @ApiModelProperty(value = "封面图")
    @Column(name = "movie_image")
    private String movieImage;

    @ApiModelProperty(value = "相关演员")
    @Column(name = "actors")
    private List<MoviePerson> actors;

    @ApiModelProperty(value = "导演")
    @Column(name = "directors")
    private List<MoviePerson> directors;

    @ApiModelProperty(value = "上映日期")
    @Column(name = "release_date")
    private Date releaseDate;

}
