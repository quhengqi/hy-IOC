package com.hy.Bean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.hy.Logger.Logger;

public interface BeanDef extends Logger{
	/**
	 * 获取未加工bean实例
	 * */
	public Object getBeanDef();
	/**
	 * 获取属性的注入方法
	 * */
	public Method getMethod(String fieldName);
	/**
	 * 获取属性类型
	 * */
	public Class<?> getFiedlType(String fieldName);
	/**
	 * 获取所有属性
	 * */
	public Field[]  getFileds();
}
