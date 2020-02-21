package com.cy.logfileread.handler.dealfile;

import com.cy.logfileread.handler.DealFileHandler;

import java.io.InputStream;

/**
 * @author zhengchaoyang
 * @date 2020/2/20
 */
public class LogDealFileHandler implements DealFileHandler {
    @Override
    public String getFileType() {
        return "log";
    }

    @Override
    public void FileType(InputStream inputStream) {

    }
}
