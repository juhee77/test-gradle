package com.lahee.psSocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
public class PsSocialApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(PsSocialApplication.class, args);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }

}
