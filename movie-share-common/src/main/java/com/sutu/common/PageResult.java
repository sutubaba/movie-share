package com.sutu.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Data
@AllArgsConstructor
public class PageResult<T> {

    /* 总记录数 */
    private Long count;

    /* 总页数 */
    private Integer page;

    /* 记录 */
    private List<T> result;
}
