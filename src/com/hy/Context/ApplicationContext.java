package com.hy.Context;

import java.util.HashMap;
import java.util.Map;

import com.hy.Factory.BeanFactory;

public interface ApplicationContext {
	public static Map<String , BeanFactory> beanFactoryCache = new HashMap<String ,BeanFactory>();
	public BeanFactory getBeanFactory();
}
