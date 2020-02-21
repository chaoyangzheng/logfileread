package com.cy.logfileread.controller;

import com.cy.logfileread.service.LogFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengchaoyang
 * @date 2020/2/21
 */
@RestController
@RequestMapping("/local")
public class ReadLocalFileController {
    @Autowired
    private LogFileService logFileService;

    @GetMapping("/log")
    public Object dealWithLocalFile(String urlPath) throws Exception {
        return logFileService.dealFile(urlPath);
    }
}
