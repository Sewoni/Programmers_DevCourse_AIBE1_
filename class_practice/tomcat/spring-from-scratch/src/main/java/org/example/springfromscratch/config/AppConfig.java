package org.example.springfromscratch.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.springfromscratch")
public class AppConfig {
    //빈(Bean)
    // @ <- 이걸로 처리해서 우리가 직접 넣어주는 경우는 많지 않음
}
