package com.bicycle;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
@MapperScan("com.bicycle.mapper")
public class Frontend {
    // 启动类
    public static void main(String[] args) {
        SpringApplication.run(Frontend.class, args);
        log.info("这是前端服务端，项目启动成功！");
    }

    /**
     * 加密
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
