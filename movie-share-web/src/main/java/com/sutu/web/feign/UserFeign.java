package com.sutu.web.feign;

import com.sutu.common.JsonResponse;
import com.sutu.common.PageResult;
import com.sutu.example.UserExample;
import com.sutu.web.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: renc
 * @2020/5/27
 * @description:
 **/
@FeignClient(value = "${movie.share.provider.name}", url = "localhost:8002")
public interface UserFeign {
    @PostMapping("/user/add")
    JsonResponse<UserDto> addUser(@RequestBody UserDto userDto);

    @PostMapping("/user/all")
    JsonResponse<PageResult> getUsers(@RequestParam String sort,
                                      @RequestParam Integer page,
                                      @RequestParam Integer size,
                                      @RequestBody UserExample example);

    @PostMapping("/user/validate")
    JsonResponse<Boolean> validateUser(@RequestBody UserDto userDto);
}
