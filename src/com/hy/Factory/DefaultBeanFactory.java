package com.hy.Factory;

import com.hy.Bean.BeanDef;
import com.hy.Source.Resource;

public interface DefaultBeanFactory extends BeanFactory {
/**
 * 从BeanCache中加载已加工Bean
 * */
public Object getBean(String BeanName);
/**
 * 从BeanDefCache中加载未加工BeanDef结构
 * */
public BeanDef getBeanDef(String BeanName);
/**
 * 从ResourceCache中加载Resource
 * */
public Resource getResource(String BeanName);
}
