package com.zyx.init.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @GetMapping("/networkTest")
    public String networkTest() {
        // 生成100k大小的随机数据
        String data = generateRandomData(100000);
        return data;
    }

    private String generateRandomData(int dataSize) {
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String data = random.ints(dataSize, 0, characters.length())
                .mapToObj(characters::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        return data;
    }
}