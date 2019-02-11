package com.drumbeatsoft;

public class MyThread implements Runnable {
    private String activityId;

    public MyThread(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public void run() {
        System.out.println(activityId);
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(activityId);
    }
}
