package com.cy.logfileread.handler;

import java.io.InputStream;

/**
 * @author zhengchaoyang
 * @date 2020/2/20
 */
public interface DealFileHandler {
    /**
     * 获取类型
     * @return 处理的文件类型
     */
    String getFileType();


    void FileType(InputStream inputStream);
}
