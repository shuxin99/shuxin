package com.shuxin.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test5 {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("run方法执行running...");
                Thread.sleep(5000);
            }
        };

        thread.setName("t1");
        log.info("start之前state:{}", thread.getState());
        thread.start();
        thread.run();
        log.info("start之后state:{}", thread.getState());

    }

}
