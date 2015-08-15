package com.hy.Factory;

import java.util.HashMap;
import java.util.Map;

import com.hy.Bean.BeanDef;
import com.hy.Source.Resource;

public interface BeanFactory {
	/**
	 * BeanName和Bean结构
	 * */
	public static Map<String , BeanDef> BeanDefCache = new HashMap<String , BeanDef> ();
	/**
	 * BeanName和成品Bean
	 * */
	public static Map<String , Object> BeanCache = new HashMap<String , Object> ();
	/**
	 * BeanName和对应的Resource,暂时用不到
	 * */
	public static Map<String ,Resource> ResourceCache = new HashMap<String , Resource>() ;
	
	public static final String SCOPE_VALUE="scope";
	/**
	 * 从BeanCache中加载已加工Bean
	 * */
	public Object getBean(String BeanName);
}
