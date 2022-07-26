package com.example.demo.controller;

import com.example.demo.entity.DynamicNacosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lsx
 * @description
 * @date: 2022/6/27 15:49
 */
@RestController
@RequestMapping("/nacos-config")
public class NacosConfigTestController {

    @Autowired
    private DynamicNacosEntity dynamicNacosEntity;


    @GetMapping("/test/{id}")
    public String getTestValue(@PathVariable("id") String id) {
        return "nacos-config应用被访问了,id=" + id + "test.version=" + dynamicNacosEntity.getVersion();
    }

}
