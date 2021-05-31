package com.spring.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring.xml");
//										리턴타입				기본생성자("문자열");
		MiTv tv1 = ctx.getBean("mitv", MiTv.class); //mitv : spring.xml의 id 밸류값
		MiTv tv2 = ctx.getBean("mitv", MiTv.class); //mitv : spring.xml의 id 밸류값
		System.out.println("tv1 : " + tv1);
		System.out.println("tv2 : " + tv2);
		
	}
}
