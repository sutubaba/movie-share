package com.sutu.web.filter;

import com.alibaba.fastjson.JSON;
import com.sutu.common.StatusCode;
import com.sutu.expection.CommonException;
import com.sutu.web.dto.UserDto;
import com.sutu.web.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
@Component
public class LoginFilter implements Filter {

    @Autowired
    private UserFeign userFeign;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        UserDto userDto = JSON.parseObject(request.getInputStream(), UserDto.class);

        Boolean flag = userFeign.validateUser(userDto).getData();


        if (!flag) {
            throw new CommonException(StatusCode.OK,"password is not correct");
        }

        UserDto loginUser = new UserDto();
        loginUser.setUsername(userDto.getUsername());
        loginUser.setPhone(userDto.getPhone());
        loginUser.setAddress(userDto.getAddress());

        HttpSession session = request.getSession();

        session.setAttribute("userInfo",loginUser);
        session.setMaxInactiveInterval(60);

        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
