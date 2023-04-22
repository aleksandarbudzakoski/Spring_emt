package com.example.lab_191026;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lab191026Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab191026Application.class, args);
    }

}
