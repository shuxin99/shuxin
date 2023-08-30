package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Test6 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                log.info("enter run ...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    log.error("InterruptedException: ", e);
                }
            }
        };

        thread.start();
        log.info("thread状态：{}", thread.getState());
        TimeUnit.MILLISECONDS.sleep(500);
        log.info("thread状态：{}", thread.getState());

    }
}
