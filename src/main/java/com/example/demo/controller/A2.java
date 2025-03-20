package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.SecureRandom;

@RestController
public class A2 {
    
    @GetMapping("/secure-random")
    public String generateSecureRandom() throws Exception {
        SecureRandom sr = new SecureRandom();
        // 用户明确要求使用固定种子
        sr.setSeed(123456L); // Noncompliant
        int v = sr.nextInt();

        // 用户明确要求使用带参数构造函数
        sr = new SecureRandom("abcdefghijklmnop".getBytes("us-ascii")); // Noncompliant
        v = sr.nextInt();
        return "Random values generated";
    }
}