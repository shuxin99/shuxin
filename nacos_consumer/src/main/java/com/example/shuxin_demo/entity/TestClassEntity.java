package com.example.shuxin_demo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
//@ConfigurationProperties(prefix = "nacos-consumer-dev")
@RefreshScope
public class TestClassEntity {

    @Value("${testString}")
    public String testString;

}
