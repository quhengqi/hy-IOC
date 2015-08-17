package com.hy.Bean;

//import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("static-access")
public class BeanDifinition implements BeanDef {
	/**
	 * 用来存放bean的所有属性
	 * */
	private  Map<String,Field> fieldsType = new HashMap<String , Field>();
	/**
	 * 用来存放bean的所有注入方法
	 * */
	private  Map<String,Method> methodsMap = new HashMap<String , Method>();
	/**
	 * 用来存放bean的所有构造器
	 * */
	private Object beanDifinition = null;
	/**
	 * 用来存放所有属性
	 * */
	private Field[] fields = null;
//	//暂时不支持构造器注入
//	private  Map<String,Constructor> constructorMap = new HashMap<String , Constructor>();
	/**
	 * 返回bean结构
	 * */
	@Override
	public Object getBeanDef() {
		return this.beanDifinition;
	}
	public BeanDifinition(String className){
		init(className);
	}	
	public void init(String className){
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
			beanDifinition = clazz.newInstance();
			logger.log("实例化[ "+beanDifinition.getClass().getName()+" ]成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取所有属性
		fields = clazz.getDeclaredFields();
		// 存储属性名+类型操作
		for(Field field : fields){
			fieldsType.put(field.getName(), field);
		}
		Method [] methods = clazz.getDeclaredMethods();
		for(Method method : methods){
			methodsMap.put(method.getName(),method);
		}
	}
	@Override
	public Method getMethod(String fieldName) {
		// 返回属性的setter注入方法
		return methodsMap.get(fieldName);
	}
	@Override
	public Class<?> getFiedlType(String fieldName) {
		// 返回属性的类型
		return fieldsType.get(fieldName).getType();
	}
	/**
	 * 属性值到方法名的转换
	 * @param=age
	 * @return=setAge
	 * */
	public String convertFieldNameToMethodName(String name){
		return new StringBuilder("set").append((name.charAt(0)+"").toUpperCase()
				+name.substring(1, name.length())).toString();
	}
	@Override
	public Field[] getFileds() {
		// TODO Auto-generated method stub
		return this.fields;
	}
}
