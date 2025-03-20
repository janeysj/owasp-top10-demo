package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class A1 {

    @PostMapping("/create-temp")
    public String createTempDir() throws IOException {
        File tempDir;
        tempDir = File.createTempFile("", ".");
        tempDir.delete();
        tempDir.mkdir();  // Noncompliant
        return "Temporary directory created at: " + tempDir.getAbsolutePath();
    }
}