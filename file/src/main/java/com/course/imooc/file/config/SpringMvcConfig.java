package com.course.imooc.file.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: 李清依
 * @Date: 2022/9/16 18:12
 * @Description:
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Value("${file.path}")
    private String FILE_PATH;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/f/**").
                addResourceLocations("file:" + FILE_PATH);
    }

}
