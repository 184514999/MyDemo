package com.drumbeatsoft;

public class Test02 {
    public static void main(String[] args) {
        System.out.println("开始");
        String a = "a";
      new Thread(new MyThread(a)).start();
      a = "b";
        System.out.println("main:   "+a);
    }
}
