package com.hy.Factory;

import java.util.HashMap;
import java.util.Map;

import com.hy.Source.XMLResource;

public class XMLBeanFactory implements BeanFactory {
	/**
	 * BeanName和对应的Resource
	 * */
	public static Map<String ,XMLResource> ResourceCache = new HashMap<String , XMLResource>() ;
	@Override
	public Object getBean(String BeanName) {
		// TODO Auto-generated method stub
		return null;
	}

}
