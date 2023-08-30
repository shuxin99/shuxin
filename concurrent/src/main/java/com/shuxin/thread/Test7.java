package com.shuxin.thread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Test7 {

    public static void main(String[] args) {
        // yield and pro

//        Runnable task1 = new Runnable() {
//            @Override
//            public void run() {
//                int count = 0;
//                log.info("1---->" + count++);
//            }
//        };
        Runnable task1 = () -> {
            int count = 0;
            while (true){
                log.info("1---->" + count++);
            }
        };

        Runnable task2 = () -> {
            int count = 0;
            while (true){
                //让出cpu时间片
//                Thread.yield();
                log.info("        2---->" + count++);
            }
        };

        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);


        t1.start();
        t2.start();

    }

}
