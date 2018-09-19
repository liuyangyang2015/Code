package org.ota.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：
 *
 * @author liuyangyang
 * @create 2018-09-19 15:57
 **/
public class ThreadPoolExecutorDemo extends ThreadPoolExecutor {
    public ThreadPoolExecutor() {
        super(1, 1,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public static void main(String[] args) {
        ThreadPoolExecutor demo1=new ThreadPoolExecutor();
        demo1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        });
        demo1.shutdown();
    }
}
