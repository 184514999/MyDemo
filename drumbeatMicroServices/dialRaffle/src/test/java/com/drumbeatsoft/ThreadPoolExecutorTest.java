package com.drumbeatsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
              boolean b = true;
              while (b){
                  System.out.println(1);
                  b = Thread.interrupted();
                  System.out.println(2);
              }
                System.out.println(3);
              if (b){
                  System.out.println(4);
              }


            }
        }).start();
        }
    }
