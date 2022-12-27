package com.course.imooc.server.config;

import com.course.imooc.server.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Auther: 李清依
 * @Date: 2022/10/28 22:34
 * @Description:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AccessDeniedHandlerImpl accessDeniedHandler;
//    @Autowired
//    private AuthenticationEntryPointImpl authenticationEntryPoint;
//    @Autowired
//    private AuthenticationSuccessHandlerImpl authenticationSuccessHandler;
//    @Autowired
//    private AuthenticationFailHandlerImpl authenticationFailHandler;
//
//    @Autowired
//    private LogoutSuccessHandlerImpl logoutSuccessHandler;
//
//
//    @Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //配置登录注销路径
//        http.formLogin()
//                .loginProcessingUrl("/login")
//                .successHandler()
//                .failureHandler()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(logoutSuccessHandler);
//        //配置路由权限消息
//        http.authorizeRequests()
//                .withObjectPostProcessor(
//                        new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                            @Override
//                            public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
//                                fsi.setSecurityMetadataSource(securityMetadataSource());
//                                fsi.setAccessDecisionManager(accessDecisionManager());
//                                return fsi;
//                            }
//                        }
//                )
//                .anyRequest().permitAll()
//                .and()
//                // 关闭跨站请求防护
//                .csrf().disable().exceptionHandling()
//                //未登录处理
//                .authenticationEntryPoint(authenticationEntryPoint)
//                //权限不足处理
//                .accessDeniedHandler(accessDeniedHandler)
//                .and()
//                .sessionManagement()
//                .maximumSessions(20)
//                .sessionRegistry(sessionRegistry());
//
//
//
//    }


}
