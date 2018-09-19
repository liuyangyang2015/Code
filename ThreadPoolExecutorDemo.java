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
        super(3, 5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),new DiscardPolicy());
    }

    public static void main(String[] args) {
        ThreadPoolExecutor demo1=new ThreadPoolExecutor();
        demo1.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        });
        
        for (int i=1;i<10;i++)
        {
            demo1.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("hi");
                    try {
                        Thread.sleep(6000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("***");
                }
            });
        }

        System.out.println(demo1.getActiveCount());
        System.out.println(demo1.getQueue().size());
        
        
        demo1.shutdown();
    }
}
