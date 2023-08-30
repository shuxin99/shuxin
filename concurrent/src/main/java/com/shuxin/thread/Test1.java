package com.shuxin.thread;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test1 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                log.info("running");
            }
        };
        thread.setName("t1");
        thread.start();
        log.info("主线程running");

    }

}
