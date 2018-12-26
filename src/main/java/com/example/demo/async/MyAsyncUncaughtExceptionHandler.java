package com.example.demo.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;


/**
 * 异步异常处理类
 *
 * @author jiaqi.liu
 */
class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
	@Autowired
	private ApplicationContext context;

	/**
	 * 异步异常处理方法
	 */
	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {

		System.out.println("获取到的bean容器:" + context);
		System.out.println("自定义异步异常处理方法获取异步异常信息:" + ex.getMessage());
		System.out.println("方法参数:" + params[0]);

	}

}
	


