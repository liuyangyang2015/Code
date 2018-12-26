package com.example.demo.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liuyangyang
 * @date 2018/12/26 19:37
 * description:
 */

@Configuration
public class MyAsyncConfigurer implements AsyncConfigurer {

	@Autowired
	private ApplicationContext context;

	/**
	 * 自定义异步线程池
	 * The {@link Executor} instance to be used when processing async
	 * method invocations.
	 */
	@Override
	public Executor getAsyncExecutor() {

		ThreadPoolExecutor pool = new ThreadPoolExecutor(0, 0, 0, null, null);
		ExecutorService es = Executors.newCachedThreadPool();
		return es;
	}

	/**
	 * 自定义异步异常处理器
	 * The {@link AsyncUncaughtExceptionHandler} instance to be used
	 * when an exception is thrown during an asynchronous method execution
	 * with {@code void} return type.
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

		return new MyAsyncUncaughtExceptionHandler();


	}
}