package com.example.demo.controller;

import com.example.demo.entity.Record;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: lsx
 * @description
 * @date: 2022/6/27 15:49
 */
@RestController
@RefreshScope
//@Configuration
@RequestMapping("/nacos-config")
public class NacosConfigTestController {

//    @Autowired
//    private DynamicNacosEntity dynamicNacosEntity;
    @Value("${version}")
    private String version;


    @GetMapping("/test/{id}")
    public String getTestValue(@PathVariable("id") String id) {
        System.out.println(version);
        return "nacos-config应用被访问了,id=" + id + "version=" + version;
    }


    public static void main(String[] args) {

        ArrayList<Record> list = new ArrayList<>();
        list.add(new Record());
//        HashSet<String> set = new HashSet<>();
//        HashMap<String, Double> resultMap = new HashMap<>();
//        for (Record record : list) {
//            if (set.contains(record.getUnitid())){
//                resultMap.put(record.getUnitid(), resultMap.get(record.getUnitid()) + record.getTmrdl());
//            }else {
//                set.add(record.getUnitid());
//                resultMap.put(record.getUnitid(), record.getTmrdl());
//            }
//        }


        Map<String, Double> collect = list.stream().collect(Collectors.groupingBy(Record::getUnitid, Collectors.summingDouble(Record::getTmrdl)));


    }



}
