package com.sutu.web.controller;

import com.sutu.common.JsonResponse;
import com.sutu.example.UserExample;
import com.sutu.web.dto.UserDto;
import com.sutu.web.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: renc
 * @2020/5/27
 * @description:
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @PostMapping("/add")
    public JsonResponse addUser(@RequestBody UserDto userDto) {
        return userFeign.addUser(userDto);
    }

    @PostMapping("/all")
    public JsonResponse getUsers(@RequestParam String sort,
                                 @RequestParam Integer page,
                                 @RequestParam Integer size,
                                 @RequestBody UserExample example) {
        return userFeign.getUsers(sort,page,size,example);
    }
}
