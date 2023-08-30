package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Test12 {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        Thread t1 = new Thread(lock::increment, "t1");
        Thread t2 = new Thread(lock::decrement, "t2");

        Thread t3 = new Thread(lock::increment2, "t3");
        Thread t4 = new Thread(lock::decrement2, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();


        log.info("main,getCount：{},getCount1:{}", lock.getCount(),lock.getCount1());
    }


}

class Lock{

    private  int count = 0;
    private  int count1 = 0;

    public void increment(){
        for (int i = 0; i < 50000; i++) {
            synchronized (this){
                count++;
            }
        }
    }

    public void decrement(){
        for (int i = 0; i < 50000; i++) {
            synchronized (this){
                count--;
            }
        }
    }

    //加在方法上实际上是锁住的当前对象this
    public synchronized void increment2(){
        for (int i = 0; i < 50000; i++) {
            count++;
        }
    }

    public synchronized void decrement2(){
        for (int i = 0; i < 50000; i++) {
                count--;
        }
    }

    public int getCount(){
        return count;
    }

    public int getCount1(){
        return count1;
    }

    public synchronized static void testMethod(){

    }
    //两者等价，synchronized只能锁对象
    public  static void testMethod1(){
        synchronized (Lock.class){

        }
    }
}