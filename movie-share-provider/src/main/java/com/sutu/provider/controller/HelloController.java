package com.sutu.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "this is the provider applicaiton";
    }
}
