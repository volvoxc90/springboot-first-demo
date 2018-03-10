package cn.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.example.*")
public class APP {

    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}
    