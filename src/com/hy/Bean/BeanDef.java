package com.hy.Bean;

import java.lang.reflect.Method;

public interface BeanDef {
	/**
	 * 获取未加工bean
	 * */
	public BeanDef getBeanDef();
	/**
	 * 获取属性的注入方法
	 * */
	public Method getMethod(String fieldName);
	/**
	 * 获取属性类型
	 * */
	public Class<?> getFiedlType(String fieldName);
}
