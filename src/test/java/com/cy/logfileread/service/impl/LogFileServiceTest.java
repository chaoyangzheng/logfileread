package com.cy.logfileread.service.impl;

import com.cy.logfileread.service.LogFileService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class LogFileServiceTest {
    @Autowired
    private LogFileService logFileService;
    @Test
    void readFile() {

    }

    @Test
    void dealFile() {
        try {
            Map<String, String> stringStringMap = logFileService.dealFile("D:\\Document\\chaoyang\\Videos\\xxxx\\test-r-snap_01.log");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}