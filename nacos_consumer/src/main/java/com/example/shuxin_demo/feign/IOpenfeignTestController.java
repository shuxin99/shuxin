package com.example.shuxin_demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: lsx
 * @description
 * @date: 2022/6/27 17:01
 */
@Component
@FeignClient(name = "nacos-provider")
public interface IOpenfeignTestController {

    @GetMapping("/provider/test/{num}")
    String invokeNacosProviderTestValue(@PathVariable("num") String num);

}
