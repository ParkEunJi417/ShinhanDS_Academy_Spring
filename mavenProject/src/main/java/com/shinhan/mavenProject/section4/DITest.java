package com.shinhan.mavenProject.section4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di4.xml");
//		PersonVO p1 = ctx.getBean("person1", PersonVO.class);
		PersonVO p2 = ctx.getBean("person2", PersonVO.class);
		
//		System.out.println(p1);
		System.out.println(p2);
	}

}