package com.cy.logfileread.service;

import java.util.Map;

/**
 * @author zhengchaoyang
 * @date 2020/2/20
 */
public interface LogFileService {
    /**
     * 网络下载
     * @param url 网络路径
     */
    void readFile(String url);

    /**
     * 处理日志文件，然后将文件分割便于查看
     *
     * @param urlPath 文件路径
     * @return map
     */
    Map<String, String> dealFile(String urlPath) throws Exception;
}
