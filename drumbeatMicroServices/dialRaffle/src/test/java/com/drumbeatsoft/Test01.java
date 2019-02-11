package com.drumbeatsoft;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                String name = Thread.currentThread().getName();
                System.out.println(name);

            }
        },1000*15,TimeUnit.MILLISECONDS);

        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
                String name = Thread.currentThread().getName();
                System.out.println(name);

            }
        },1000*10,TimeUnit.MILLISECONDS);

        Thread.sleep(1000*20);


        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
                String name = Thread.currentThread().getName();
                System.out.println(name);

            }
        },1000*10,TimeUnit.MILLISECONDS);


    }
}
