package org.ota.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
				new LinkedBlockingQueue<Runnable>(3), new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.out.println("aiai");
					}
				});
	}

	public static void main(String[] args) {
		ThreadPoolExecutorDemo demo1 = new ThreadPoolExecutorDemo();
		for (int i = 1; i < 12; i++) {
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
//public class ThreadPoolExecutorDemo extends ThreadPoolExecutor {
//	public static volatile Integer num = 1;
//	public ThreadPoolExecutorDemo() {
////        super(3, 5,
////                60,
////                TimeUnit.SECONDS,
////                new LinkedBlockingQueue<Runnable>(3));
////        super(3, 5,
////                60,
////                TimeUnit.SECONDS,
////                new LinkedBlockingQueue<Runnable>(3),new DiscardPolicy());
//		super(3, 5,
//				60,
//				TimeUnit.SECONDS,
//				new LinkedBlockingQueue<Runnable>(3),new RejectedExecutionHandler()
//				{
//					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//						System.out.println("aiai"+Thread.currentThread().getName());
//					}
//				});
//	}
//
//	//    public static void main(String[] args) {
//	public static void main1(String[] args) {
//
//		ThreadPoolExecutorDemo demo1=new ThreadPoolExecutorDemo();
//
//		try{
//			for (int i=1;i<20;i++)
//			{
//				demo1.execute(new Runnable() {
//					@Override
//					public void run() {
//
//						if(num <= 5)
//						{
//							num++;
//							throw  new RuntimeException("123"+Thread.currentThread().getName());
//						}
//						System.out.println("hi");
//						try {
//							Thread.sleep(6000000);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						System.out.println("***");
////                        throw  new Exception("123"+Thread.currentThread().getName());
//					}
//				});
//			}
//		}catch (Exception e)
//		{
//			System.out.println("error"+e);
//		}
//
//		System.out.println(demo1.getActiveCount());
//		System.out.println(demo1.getQueue().size());
//
//		demo1.shutdown();
//	}
//
//	//    public static void main(String[] args) {
//	public static void main(String[] args) {
//		//下面有3中方式来执行线程。
//		//第1种按照普通的方式。这是能捕获到异常
//		try{
//			Thread t = new Thread(new ExceptionThread2());
//			t.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
//			t.start();
//		}
//		catch (Exception e)
//		{
//			System.out.println("error1:  "+e);
//		}
//
//		//第2种按照现成池，直接按照thread方式,此时不能捕获到异常，为什么呢？因为在下面代码中创建了一个线程，且设置了异常处理器，
//		//但是呢，在我们线程池中会重设置新的Thread对象，而这个Thread对象没有设置任何异常处理器，换句话说，我们在线程池外对线程做的
//		//任何操作都是没有用的
//		try{
//			ExecutorService exec1 = Executors.newCachedThreadPool();
//			Runnable runnable = new ExceptionThread2();
//			Thread t1 = new Thread(runnable);
//			t1.setUncaughtExceptionHandler(new MyUnchecckedExceptionhandler());
//			exec1.execute(runnable);
//		}
//		catch (Exception e)
//		{
//			System.out.println("error2:   "+e);
//		}
//
//
//		//第3种情况一样的，也是走的线程池，但是呢是通过ThreadFactory方式，在ThreadFactory中会对线程做一些控制，可以设置异常处理器
//		//此时是可以捕获异常的。
//		try{
//			ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
//			exec.execute(new ExceptionThread2());
//		}
//		catch (Exception e)
//		{
//			System.out.println("error3:  "+e);
//		}
//
//
//	}
//
//}