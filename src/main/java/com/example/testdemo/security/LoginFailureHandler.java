package com.example.testdemo.security;

import cn.hutool.json.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/22
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //httpServletResponse.setStatus(HttpStatus.FAILED_DEPENDENCY.value());
        //logger.info("登录失败");
        //设置状态码
        httpServletResponse.setStatus(500);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //将 登录失败 信息打包成json格式返回
        //httpServletResponse.getWriter().write(JSON.toJSONString(ServerResponse.createByErrorMessage(exception.getMessage())));

    }
}
