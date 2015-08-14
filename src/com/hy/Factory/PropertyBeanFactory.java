package com.hy.Factory;

import com.hy.Bean.BeanDef;
import com.hy.Source.Resource;

public class PropertyBeanFactory implements DefaultBeanFactory{

	@Override
	public Object getBean(String BeanName) {
		//如果scope值为prototype,直接创建新的bean
		if(getResource(BeanName).getValueCache().get(SCOPE_VALUE).equals("prototype")){
			return doCreateBean(BeanName);
		}
		// 如果scope的值为singleton,优先加载缓存,否则创建新的bean
		Object bean = BeanDefCache.get(BeanName);
		return  bean != null?bean:doCreateBean(BeanName);
	}
	
	private BeanDef doCreateBean(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDef getBeanDef(String BeanName) {
		// TODO Auto-generated method stub
		return BeanDefCache.get(BeanName);
	}

	@Override
	public Resource getResource(String BeanName) {
		// TODO Auto-generated method stub
		return ResourceCache.get(BeanName);
	}

}
