package com.code.demo;

/**
 * @author liuyangyang
 * @date 2018/12/30 15:17
 */

public class EqualsDemo {
	public static void main(String[] args) {
		int a= 5225;
		int b=5225;
		System.out.println(a==b);
		Integer c= new Integer(1);
		Integer d= new Integer(1);
		System.out.println(c == d);
		int e =1;
		System.out.println(c==e);
	}
}
