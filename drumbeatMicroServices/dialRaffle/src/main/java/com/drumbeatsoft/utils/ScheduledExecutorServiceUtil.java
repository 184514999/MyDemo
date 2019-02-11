package com.drumbeatsoft.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledExecutorServiceUtil {
    public static ScheduledExecutorService service = Executors.newScheduledThreadPool(9);

    public static ScheduledExecutorService getService(){
        return service;
    }
}
