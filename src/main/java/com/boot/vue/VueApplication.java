package com.boot.vue;

import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = {"com.boot.vue"})
@MapperScan("com.boot.vue.mapper")
public class VueApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueApplication.class, args);
    }

}
