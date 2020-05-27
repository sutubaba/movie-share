package com.sutu.expection;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Data
@AllArgsConstructor
public class CommonException extends RuntimeException {

    private String code;

    private String message;

}
