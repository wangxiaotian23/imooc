package com.course.imooc.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * @Auther: 李清依
 * @Date: 2022/8/29 20:05
 * @Description:e
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.course.imooc")
@MapperScan("com.course.imooc.server.mapper")
public class SystemApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SystemApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SystemApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("System地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
