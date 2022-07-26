package com.example.shuxin_demo.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

/**
 * @author: lsx
 * @description
 * @date: 2022/6/24 16:06
 */
@RestController
@RequestMapping("/provider")
public class NacosProviderController {

    @Value("${spring.application.name}")
    String appName;

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/test/{num}")
    public String getTestData(@PathVariable("num") String num) {
        return appName + ":" + port + "provider测试数据num=" + num;
    }


    public static void main(String[] args) {

        ok:

        for (int i = 0; i < 10; i++) {
            System.out.println("外层：" + i);
            for (int j = 0; j < 5; j++) {
                System.out.println("里层：" + j);
                if (j==3){
                    break ok;
                }
            }
        }



    }




}
