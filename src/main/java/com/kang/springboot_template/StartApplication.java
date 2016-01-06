package com.kang.springboot_template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//@Controller
@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@ComponentScan("com.kang")
public class StartApplication {

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    } 

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartApplication.class, args);
    }
}