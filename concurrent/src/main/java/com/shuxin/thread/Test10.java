package com.shuxin.thread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Test10 {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            try {
                log.info("洗水壶。。。");
                //洗水壶
                TimeUnit.SECONDS.sleep(1);
                //烧开水
                log.info("灌水烧开水。。。");
                TimeUnit.SECONDS.sleep(15);
                log.info("水烧开啦。。。");
            } catch (InterruptedException e) {
                log.error("InterruptedException",e);
            }
        }, "t1");

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                log.info("洗茶壶。。。");
                //洗茶壶
                TimeUnit.SECONDS.sleep(1);
                //洗茶杯
                log.info("洗茶杯。。。");
                TimeUnit.SECONDS.sleep(2);
                //拿茶叶
                log.info("拿茶叶。。。");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("InterruptedException",e);
            }
        }, "t2");

        t2.start();

        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        log.info("泡茶喝,cost time :{} ms", endTime - startTime);


    }
}
