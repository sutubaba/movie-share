package com.sutu.provider.controller;

import com.sutu.common.JsonResponse;
import com.sutu.common.StatusCode;
import com.sutu.example.UserExample;
import com.sutu.provider.entity.User;
import com.sutu.provider.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户")
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户实体")
    })
    public JsonResponse addUser(@RequestBody User user) {

        User u = userService.addUser(user);

        return new JsonResponse(StatusCode.OK,"add user successful",u);
    }

    @ApiOperation(value = "用户详情")
    @GetMapping("/get")
    public JsonResponse getUserById(@ApiParam(value = "用户Id") @RequestParam Integer id) {
        User user = userService.findUserById(id);
        return new JsonResponse(StatusCode.OK, "find user successful", user);
    }

    @ApiOperation(value = "用户列表")
    @PostMapping("/all")
    public JsonResponse getUsers(@ApiParam(value = "页码") @RequestParam(required = false) Integer page,
                                 @ApiParam(value = "页码大小") @RequestParam(required = false) Integer size,
                                 @ApiParam(value = "排序方式") @RequestParam(required = false) String sort,
                                 @ApiParam(value = "用户查询实体") @RequestBody(required = false) UserExample example) {
        return new JsonResponse(StatusCode.OK, "get user list successful ", userService.findAll(sort,page,size,example)) ;
    }

    @ApiOperation(value = "用户验证")
    @PostMapping("/validate")
    public JsonResponse validateUser(@ApiParam(value = "用户实体") @RequestBody User user) {
        Boolean flag = userService.validateUser(user);
        return new JsonResponse(StatusCode.OK,"login result", flag);
    }
}
