package com.qrservice1.qrservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class QrService1Application {

    @GetMapping("/message")
    public String message(){
        return " Web application  has ben deployed to azure successfully  !";
    }
    public static void main(String[] args) {
        SpringApplication.run(QrService1Application.class, args);
    }

}
