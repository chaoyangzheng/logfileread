package com.cy.logfileread.service.impl;

import com.cy.logfileread.service.LogFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhengchaoyang
 * @date 2020/2/20
 */
@Slf4j
@Service
public class LogFileServiceImpl implements LogFileService {

   /* @Autowired
    private RedisTemplate<String, String> redisTemplate;*/

    @Override
    public void readFile(String filePathUrl) {
        try {
            File file = new File("D:/abc.log");
            if (!file.exists()) {
                boolean mkdirs = file.createNewFile();
                if (!mkdirs) {
                    log.error("文件无法创建，请确认程序权限");
                    return;
                }
            }
            // 创建URL
            URL url = new URL(filePathUrl);
            // 试图连接并取得返回状态码
            URLConnection urlConn = url.openConnection();
            urlConn.connect();
            int connectTimeout = urlConn.getConnectTimeout();
            urlConn.setConnectTimeout(Integer.MAX_VALUE);
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            // 服务器返回的状态
            int httpResult = httpConn.getResponseCode();
            if (httpResult != HttpURLConnection.HTTP_OK) {
                System.out.print("无法连接到 " + filePathUrl);
            } else {
                // 取数据长度
                int fileSize = urlConn.getContentLength();
                System.out.println(fileSize);
                long start = System.currentTimeMillis();
                InputStream inStream = urlConn.getInputStream();
                FileOutputStream fs = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                //int length;
                int bytesum = 0;
                int byteread = 0;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                }
                fs.flush();
         /*       InputStreamReader isReader = new InputStreamReader(urlConn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(isReader);
                FileOutputStream outputStream = new FileOutputStream(file, true);
                long start = System.currentTimeMillis();
                String s;
                while (!(s = reader.readLine()).isEmpty()) {
                    byte[] bytes = s.getBytes();
                    outputStream.write(bytes);
                }*/
                log.info("耗时：{}ms", System.currentTimeMillis() - start);

                fs.close();
                inStream.close();


                //BufferedOutputStream buffereOutStream = new BufferedOutputStream(outputStream,fileSize);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Map<String, String> dealFile(String urlPath) throws Exception {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //2020-01-16 12:55:58.775
        //String logtest = "logtest";
       FileInputStream fileInputStream = new FileInputStream(urlPath);
        byte[] readByte = new byte[4096];
        int i = 0;
        while (fileInputStream.read(readByte) > 0) {
            String str = new String(readByte);
            String[] split = str.split("\r\n");
            for (String s : split) {
                map.put(++i + "", s);
                log.info(s);
                log.info("----------------------");
            }
        }


        //List<Object> list = redisTemplate.opsForHash().multiGet(logtest, Arrays.asList("a", "b", "c"));

        return map;
    }

}














