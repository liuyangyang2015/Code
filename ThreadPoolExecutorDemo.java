package org.ota.service;

import java.util.concurrent.*;

/**
 * 描述：
 *
 * @author liuyangyang
 * @create 2018-09-19 15:57
 **/
public class ThreadPoolExecutorDemo extends ThreadPoolExecutor {
    public ThreadPoolExecutorDemo() {
//        super(3, 5,
//                60,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<Runnable>(3));
//        super(3, 5,
//                60,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<Runnable>(3),new DiscardPolicy());
        super(3, 5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),new RejectedExecutionHandler()
                {
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("aiai");
                    }
                });
    }

    public static void main(String[] args) {
        ThreadPoolExecutorDemo demo1=new ThreadPoolExecutorDemo();
        for (int i=1;i<12;i++)
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

hi
hi
hi
hi
hi
aiai
aiai
aiai
5
3
