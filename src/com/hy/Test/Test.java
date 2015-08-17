package com.hy.Test;

import com.hy.Factory.BeanFactory;
import com.hy.Factory.PropertyBeanFactory;
import com.hy.Reader.PropertySourceReader;
import com.hy.Reader.SourceReader;
import com.hy.Source.PropertyResource;
import com.hy.Source.Resource;

public class Test {
	public static void main(String[] args) {
		String PersonPath = "com\\hy\\Test\\person_config.properties";
		BeanFactory factory = new PropertyBeanFactory(PersonPath);
		Person p1 = (Person)factory.getBean("person");
		System.out.println("p1="+p1);
		p();
		SourceReader reader = new PropertySourceReader();
		reader.bingConfigPath(PersonPath);
		Resource source =new PropertyResource();
		source.bindReader(reader);
		BeanFactory factory2 = new PropertyBeanFactory(source);
		Person p2 = (Person)factory2.getBean("person");
		System.out.println("p2="+p2);
		p();
		BeanFactory factory3 = new PropertyBeanFactory(new PropertyResource(new PropertySourceReader(PersonPath)));
		Person p3 = (Person)factory3.getBean("person");
		System.out.println("p3="+p3);
		p();
		BeanFactory factory4 = new PropertyBeanFactory(new PropertyResource(PersonPath));
		Person p4 = (Person)factory4.getBean("person");
		System.out.println("p4="+p4);
	}
	@org.junit.Test
	public void test2(){
		String path = "com.hengyuan.example.person_config";
		System.out.println(new StringBuilder(path.replaceAll(".", "\\")).append(".properties").toString());
	}
	public static void p(){
		System.out.println("*******************************************************************");		
	}
}
