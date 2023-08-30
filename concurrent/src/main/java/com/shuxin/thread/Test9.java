package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class Test9 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = test();
        Thread.sleep(1000);
        t.interrupt();

    }

    public static Thread test(){
        Thread t1 = new Thread(() -> {
            log.info("park...");
            LockSupport.park();
            log.info("unPark...");
//            log.info("interrupt:{}", Thread.currentThread().isInterrupted());
            log.info("interrupt:{}", Thread.interrupted());
            log.info("当前interrupt:{}", Thread.currentThread().isInterrupted());
            log.info("park...");
            LockSupport.park();
            log.info("unPark...");
        }, "t1");
        t1.start();
        return t1;
    }



}
