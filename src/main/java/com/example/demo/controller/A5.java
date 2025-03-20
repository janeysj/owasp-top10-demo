package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@RestController
public class A5 {
    
    @PostMapping("/parse-xml")
    public String parseXml(@RequestParam String xml) {
        try {
            // 安全漏洞：未禁用外部实体处理
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.parse(new InputSource(new StringReader(xml)));
            return "XML解析成功，但存在XXE漏洞：\n1. 未禁用外部实体处理";
        } catch (Exception e) {
            return "XML解析异常：" + e.getMessage();
        }
    }
}