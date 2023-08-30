package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test11 {

    public static int count = 0;

    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
//        getCount();
        getCountWithSynchronized();
    }

    /**
     * 存在线程安全问题
     *
     * @throws InterruptedException
     */
    private static void getCount() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count--;
            }
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        log.info("count:{}", count);
    }


    private static void getCountWithSynchronized() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (lock) {
                    count--;
                }
            }
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        log.info("count:{}", count);
    }

}