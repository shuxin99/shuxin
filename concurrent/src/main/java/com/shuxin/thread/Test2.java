package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "con.Test2")
public class Test2 {

    public static void main(String[] args) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("running");
            }
        };

        Thread thread = new Thread(runnable,"t1");
        thread.start();

        log.info("running");
    }

}
