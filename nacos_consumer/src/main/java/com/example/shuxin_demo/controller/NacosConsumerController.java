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

        return restTemplate.getForObject("http://localhost:8001/provider/test/" + number, String.class);
    }

    @GetMapping("/test2/{number}")
    public String testProvider2(@PathVariable("number") String number) {
        return restTemplate.getForObject("http://nacos-provider/provider/test/" + number, String.class);
    }


    @GetMapping("/test3/{number}")
    public String testProvider3(@PathVariable("number") String number) {

        return openfeign.invokeNacosProviderTestValue(number);

    }

}
