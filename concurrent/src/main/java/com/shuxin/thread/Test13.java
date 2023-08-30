package com.shuxin.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
public class Test13 {

    public static void main(String[] args) throws InterruptedException {

        Account a = new Account(1000);
        Account b = new Account(1000);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                a.transfer(b, random.nextInt(5));
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                b.transfer(a, random.nextInt(5));
            }
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t1.join();
        log.info("账户的总额:{}", a.getMoney() + b.getMoney());
    }

    static Random random = new Random();

}

class Account {

    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void transfer(Account account, int amount) {
        //简单处理 但效率极低，如果有多个账户，只有两个可以转账
        synchronized (Account.class) {
            int temp = this.money - amount;
            if (temp > 0) {
                this.setMoney(temp);
                account.setMoney(account.getMoney() + amount);
                ;
            }
        }
    }


}
