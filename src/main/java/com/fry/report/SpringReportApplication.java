package com.fry.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author qtx
 */
@EnableScheduling
@SpringBootApplication
public class SpringReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReportApplication.class, args);
    }

}
