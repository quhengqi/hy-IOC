package com.hy.Bean;

//import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanDifinition implements BeanDef {
	/**
	 * 用来存放bean的所有属性的类型
	 * */
	private  Map<String,Field> fieldsMap = new HashMap<String , Field>();
	/**
	 * 用来存放bean的所有注入方法
	 * */
	private  Map<String,Method> methodsMap = new HashMap<String , Method>();
	/**
	 * 用来存放bean的所有构造器
	 * */
//	//暂时不支持构造器注入
//	private  Map<String,Constructor> constructorMap = new HashMap<String , Constructor>();
	@Override
	public BeanDef getBeanDef() {
		// 返回自身
		return this;
	}
	@Override
	public Method getMethod(String fieldName) {
		// 返回属性的setter注入方法
		return methodsMap.get(fieldName);
	}
	@Override
	public Class<?> getFiedlType(String fieldName) {
		// 返回属性的类型
		return fieldsMap.get(fieldName).getType();
	}

}
