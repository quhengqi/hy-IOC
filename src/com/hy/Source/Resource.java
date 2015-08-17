package com.hy.Source;

import java.util.Map;

import com.hy.Logger.Logger;

public interface Resource extends Logger{
	/**
	 * 返回类的全局限定名
	 * */
	public String getClassName();
	/**
	 * 返回类的自定义名
	 * */
	public String getBeanName();
	/**
	 * 用来存放bean的属性及其属性值,皆以String类型存储
	 * */
	public Map<String , String> getValueCache();
	/**
	 * 获取加载路径
	 * */
	public String getConfigPath();
}
