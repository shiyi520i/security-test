package com.example.testdemo.config;

import com.example.testdemo.security.LoginFailureHandler;
import com.example.testdemo.security.LoginSuccessHandler;
import com.example.testdemo.security.MyLogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

/**
 * 认证授权类
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/17
 */
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Autowired
    private MyLogoutHandler logoutHandler;

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //开启登录页面
                .formLogin()
                //设置登录页面
               // .loginPage("/login.html")
                //.loginProcessingUrl("/login") 页面ation里的url
                // 登录成功
                .successHandler(loginSuccessHandler)
                .defaultSuccessUrl("/success")
                // 登录失败
                .failureHandler(loginFailureHandler).permitAll()
                .and()
                // 注销成功
                .logout().logoutSuccessHandler(logoutHandler)
                /*.and()
                // 未登录请求资源
                .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .and()
                .authorizeRequests()
                //以下为授权,通过投票机制是否授权通过
                .antMatchers("/login.html").permitAll()
                .antMatchers(HttpMethod.POST, "/test2").hasAuthority("add")
                .antMatchers(HttpMethod.GET, "/test2").hasAuthority("query")
                .antMatchers("/home").hasAuthority("base")*/
                //关闭跨站请求防护
                .and()
                .csrf().disable();


        http.authorizeRequests().antMatchers("/static/**"
                        ,"/swagger-resources/**"

                        ,"/swagger-ui/**"

                ).permitAll()  //,"/v3/**",,"/v2/**"
                //访问/test3需要有p1权限
                .antMatchers("/test3").hasAuthority("p1")
                .antMatchers("/a").authenticated()
                //其他请求必需验证通过
                .anyRequest().permitAll()
                .and()
                //启动登出功能
                .logout()
                //登出url
                .logoutUrl("/logout")
                //登出之后的URL
                .logoutSuccessUrl("/");

    }

    /**
     *  加密
     * @author ShiYi
     * @return org.springframework.security.crypto.password.PasswordEncoder
     * @date 2021/9/24 11:20
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
