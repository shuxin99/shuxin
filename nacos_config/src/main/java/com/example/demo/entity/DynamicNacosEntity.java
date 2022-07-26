package com.example.demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author: lsx
 * @description
 * @date: 2022/6/27 15:47
 */
@Data
@Component
@RefreshScope  //动态刷新配置
public class DynamicNacosEntity {

    //测试版本
    @Value("${test.version}")
    private String version;
}
