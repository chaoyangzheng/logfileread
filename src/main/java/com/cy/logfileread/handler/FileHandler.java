package com.cy.logfileread.handler;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jerry.liu
 * @date Create in 2020/1/7 22:04
 */
public class FileHandler {
    @Resource
    private List<DealFileHandler> dealFileHandlers;


    /**
     * 获取入库流水处理
     *
     * @param fileType 文件
     * @return 文件处理函数
     */
    public DealFileHandler getDealFileHandler(String fileType) {
        return dealFileHandlers.stream().filter(x -> x.getFileType().equals(fileType)).findFirst().orElse(null);
    }

   /*
    public OutFlowTransactionHandler getOutFlowHandler(String transactionType) {
        return outFlowTransactionHandlers.stream().filter(x -> x.getFileType().equals(transactionType)).findFirst().orElse(null);
    }*/
}
