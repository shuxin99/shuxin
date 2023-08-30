package com.example.shuxin_demo.controller;

import com.example.shuxin_demo.entity.TestClassEntity;
import com.example.shuxin_demo.feign.IOpenfeignTestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lsx
 * @description
 * @date: 2022/6/24 16:40
 */
@RestController
@RequestMapping("/consumer")
public class NacosConsumerController {

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private IOpenfeignTestController openfeign;

//    private String string;
//
//    @Value("${testString}")
//    public void setString(String string) {
//        this.string = string;
//    }

    @Autowired
    private TestClassEntity entity;

    @GetMapping("/test/{number}")
    public String testProvider(@PathVariable("number") String number) {
        //localhost:8001    加了@LoadBalanced注解，找不到，不加可以正常使用
        return restTemplate.getForObject("http://localhost:8001/provider/test/" + number, String.class);
    }

    @GetMapping("/test2/{number}")
    public String testProvider2(@PathVariable("number") String number) {
        //使用@LoadBalance  可以找到，不加找不到，提示未知主机
        return restTemplate.getForObject("http://nacos-provider/provider/test/" + number, String.class);
    }


    @GetMapping("/test3/{number}")
    public String testProvider3(@PathVariable("number") String number) {
        //feigin
        return openfeign.invokeNacosProviderTestValue(number);

    }


    @GetMapping("/test4")
    public String testProvider3() {
        //feigin
        return entity.getTestString();

    }

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(s += 'a');
    }

}
