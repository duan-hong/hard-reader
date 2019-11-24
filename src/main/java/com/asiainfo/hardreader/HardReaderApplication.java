package com.asiainfo.hardreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HardReaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardReaderApplication.class, args);
    }

}
