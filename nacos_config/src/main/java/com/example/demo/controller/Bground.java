package com.example.demo.controller;


public class Bground extends Thread{

    @Override
    public void run() {
        System.out.println("run方法啦啦啦啦");
    }

    public static void main(String argv[]){
        Bground b = new Bground();
        b.start();
//        b.run();
    }
//    public void start(){
//        for(int i=0;i<10;i++){
//            System.out.println("Value of i = "+i);
//        }
//    }
}