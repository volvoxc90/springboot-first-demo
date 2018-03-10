package cn.example;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.example.mapper")
public class APP {

    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}
    