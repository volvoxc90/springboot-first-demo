package cn.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.example.*")
public class SpringbootFirstDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFirstDemoApplication.class, args);
    }
}
    