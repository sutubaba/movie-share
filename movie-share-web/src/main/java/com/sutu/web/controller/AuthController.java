package com.sutu.web.controller;

import com.sutu.common.JsonResponse;
import com.sutu.common.StatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public JsonResponse login(HttpServletRequest request) {

        return new JsonResponse(StatusCode.OK,"login in successful",request.getSession().getAttribute("userInfo"));
    }

}
