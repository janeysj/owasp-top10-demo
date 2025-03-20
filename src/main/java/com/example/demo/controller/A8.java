package com.example.demo.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class A8 {
    
    // 反序列化漏洞示例1：信任所有包
    public void unsafeConfig1() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setTrustAllPackages(true); // Noncompliant - 反序列化漏洞风险
    }

    // 反序列化漏洞示例2：未设置可信包
    public void unsafeConfig2() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        // 缺少trustedPackages设置 - 反序列化漏洞风险
    }
}