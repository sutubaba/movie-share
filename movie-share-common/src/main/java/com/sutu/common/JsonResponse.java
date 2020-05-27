package com.sutu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Data
public class JsonResponse<T> {

    private String code;

    private String message;

    private T data;

    public JsonResponse() {}

    public JsonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
