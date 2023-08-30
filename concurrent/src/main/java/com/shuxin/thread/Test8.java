package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Test8 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true){
                log.info("**************");
                if (Thread.currentThread().isInterrupted()){
                    log.info("有人打断我");
//                    try {
//                        log.info(Thread.currentThread().getName() + "sleep...start");
//                        TimeUnit.SECONDS.sleep(3);
//                        log.info(Thread.currentThread().getName() + "sleep...end");
//                    } catch (InterruptedException e) {
//                        log.error("InterruptedException", e);
//                    }
                    break;
                }
            }
        }, "t1");

        t1.start();

        TimeUnit.SECONDS.sleep(1);
        log.info("interrupt...");
        t1.interrupt();
        log.info("interrupted...");

    }
}
