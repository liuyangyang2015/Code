package org.ota.service;

import java.util.concurrent.*;

/**
 * 描述：
 *
 * @author liuyangyang
 * @create 2018-09-19 15:57
 **/

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("创建一个新的线程");
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
        System.out.println("eh121 = " + t.getUncaughtExceptionHandler());
        return t;
    }

}
class MyUnchecckedExceptionhandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(Thread.currentThread().getName()+"   捕获到异常：" + e);
    }

}
class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by" + t);
        System.out.println("eh=" + t.getUncaughtExceptionHandler());
        throw new RuntimeException("抛出运行时异常");
    }
}
