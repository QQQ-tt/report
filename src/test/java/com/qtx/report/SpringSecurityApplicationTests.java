package com.qtx.report;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringSecurityApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
    }

}
