package com.sutu.provider.exception;

import com.sutu.common.JsonResponse;
import com.sutu.common.StatusCode;
import com.sutu.expection.CommonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: renc
 * @2020/5/27
 * @description:
 **/
@ControllerAdvice
public class ProviderExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResponse handleException(RuntimeException ex) {
        return new JsonResponse(StatusCode.SERVER_ERROR,ex.getMessage());
    }

    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public JsonResponse handleCommonException(CommonException ex) {
        return new JsonResponse(ex.getCode(),ex.getMessage());
    }
}
