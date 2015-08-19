package com.hy.Factory;

import java.util.HashMap;
import java.util.Map;

import com.hy.Bean.BeanDef;
import com.hy.Logger.Logger;

public interface BeanFactory  extends Logger{
	/**
	 * BeanName和Bean结构
	 * */
	public static Map<String , BeanDef> BeanDefCache = new HashMap<String , BeanDef> ();
	/**
	 * BeanName和成品Bean
	 * */
	public static Map<String , Object> BeanCache = new HashMap<String , Object> ();
	
	public static final String SCOPE_VALUE="scope";
	/**
	 * 获取名字为BeanName的bean实例
	 * */
	public Object getBean(String BeanName);
}
