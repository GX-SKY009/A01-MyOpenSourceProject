package com.sky.stu.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: Code05
 * @description: 拦截器配置类
 * @author: 云上幻歌
 * @create: 2021-08-31 13:48
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截请求，必须用户登录后才可以访问
        String[] addPathPatterns = {"/admin/**","/stu/**"};

        //用户不登录也可以访问
        String[] excludePathPatterns = {"/","/login"};
        registry.addInterceptor(new SystemInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
