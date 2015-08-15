package com.hy.Test;

import com.hy.Factory.BeanFactory;
import com.hy.Factory.PropertyBeanFactory;

public class Test {
	public static void main(String[] args) {
		String path = "com\\hy\\Test\\person_config.properties";
		BeanFactory factory = new PropertyBeanFactory(path);
		Person p1 = (Person)factory.getBean("person");
		System.out.println(p1);
		Person p2 = (Person)factory.getBean("person");
		System.out.println(p2);
	}
	@org.junit.Test
	public void test2(){
		String path = "com.hengyuan.example.person_config";
		System.out.println(new StringBuilder(path.replaceAll(".", "\\")).append(".properties").toString());
	}
}
