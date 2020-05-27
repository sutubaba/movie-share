package com.sutu.web.filter;

import com.sutu.common.StatusCode;
import com.sutu.expection.CommonException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: renc
 * @2020/5/26
 * @description:
 **/
public class StatusFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        if (session.getAttribute("userInfo") == null) {
            throw new CommonException(StatusCode.FORBIDDEN, "login time out");
        }

        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
