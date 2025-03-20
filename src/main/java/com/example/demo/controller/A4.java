package com.example.demo.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Base64;

@RestController
public class A4 {
    
    @PostMapping("/insecure-request")
    public String makeInsecureRequest(@RequestParam String url) {
        // 安全漏洞：使用硬编码的凭证进行Base64编码
        String encoding = Base64.getEncoder()
                .encodeToString("login:passwd".getBytes());
        
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        
        // 安全风险：明文传输认证信息，缺乏加密措施
        httpPost.setHeader("Authorization", "Basic " + encoding);  
        
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            return "请求成功，但存在严重安全漏洞：\n"
                    + "1. 使用固定凭证（login:passwd）\n"
                    + "2. Basic认证明文传输凭证\n"
                    + "3. 缺乏HTTPS加密通信";
        } catch (IOException e) {
            e.printStackTrace();
            return "请求处理异常：" + e.getMessage();
        }
    }
}