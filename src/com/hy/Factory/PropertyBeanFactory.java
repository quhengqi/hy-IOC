package com.hy.Factory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.hy.Bean.BeanDef;
import com.hy.Bean.BeanDifinition;
import com.hy.Source.PropertyResource;
import com.hy.Source.Resource;

public class PropertyBeanFactory implements DefaultBeanFactory{
	//bean结构
	private BeanDef beanDef = null;
	//bean资源
	private Resource resource = null;
	@Override
	//返回bean
	public Object getBean(String BeanName) {
		if(getResource(BeanName) != null){
			if(getResource(BeanName).getValueCache().get(SCOPE_VALUE).equals("prototype")){
				return doCreateBean(BeanName,false);
			}else{
				// 如果scope的值为singleton,优先加载缓存,否则创建新的bean
				System.out.println("加载缓存");
				Object bean = BeanCache.get(BeanName);
				return  bean != null?bean:doCreateBean(BeanName,true);
			}
		}
		return doCreateBean(BeanName,false);
	}
	public PropertyBeanFactory(String configPath){
		//初始化资源
		init(configPath);
	}
	/**
	 * 初始化方法
	 * */
	private void init(String configPath) {
		resource = new PropertyResource(configPath);
	}
	/**
	 * 创建bean方法
	 * */
	private Object doCreateBean(String BeanName , boolean needCache) {
		System.out.println("创建bean");
		Object ProcesstBean = null;
		String ClassName = null;
		//从资源文件中获得bean的全局限定名
		ClassName = resource.getClassName();
		//将资源存入缓存
		ResourceCache.put(BeanName, resource);
		//生成新的beanDef
		beanDef = new BeanDifinition(ClassName);
		ProcesstBean = beanDef.getBeanDef();
		//将原始形态的bean存入缓存
		BeanDefCache.put(BeanName, beanDef);
		// 解析并装配bean
		Map<String, String> fieldValue = resource.getValueCache();
		Field [] fields =beanDef.getFileds();

		for(int i = 0 ;i <fields.length ; i++){
			try {
				Object requiredType =beanDef.getFiedlType(fields[i].getName());
				Object requiredValue =convertToRequiredType(requiredType,fieldValue.get(fields[i].getName()));
				beanDef.getMethod(convertFieldNameToMethodName(fields[i].getName())).invoke(ProcesstBean, requiredValue);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(needCache){
			BeanCache.put(BeanName, ProcesstBean);
		}
		return ProcesstBean;
	}
	/**
	 * 属性类型转换器
	 * */
	private Object convertToRequiredType(Object requiredType, String value) {
		// TODO Auto-generated method stub
		if(requiredType==String.class){
			return value;
		} 
		if(requiredType == int.class){
			return Integer.parseInt(value);
		} 
		if(requiredType == boolean.class){
			return new Boolean(value);
		} 
		if(requiredType == double.class){
			return Double.parseDouble(value);
		}
		if(requiredType == short.class){
			return Short.parseShort(value);				
		}
		if(requiredType == long.class){
			return Long.parseLong(value);
		}
		if(requiredType == char.class){
			char[] temp = value.toCharArray();
			return temp[0];
		}if(requiredType == byte.class){
			byte[] temp = value.getBytes();
			return temp[0];
		}	
		return null;
	}
	@Override
	/**
	 * 从BeanDefCache缓存中返回beanDef
	 * */
	public BeanDef getBeanDef(String BeanName) {
		// TODO Auto-generated method stub
		return BeanDefCache.get(BeanName);
	}

	@Override
	/**
	 * 从ResourceCache缓存中返回资源
	 * */
	public Resource getResource(String BeanName) {
		// TODO Auto-generated method stub
		return ResourceCache.get(BeanName);
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
}
