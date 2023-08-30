package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class Test3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("running");
                Thread.sleep(2000);
                return "OK";
            }
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask,"t1");

        thread.start();
        log.info("running");
        log.info("result:{}", futureTask.get());

    }

}
