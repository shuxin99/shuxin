package com.example.shuxin_demo.controller;

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

}
