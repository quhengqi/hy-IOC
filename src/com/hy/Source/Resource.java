package com.hy.Source;

import java.util.HashMap;
import java.util.Map;

import com.hy.Logger.Logger;
import com.hy.Reader.SourceReader;

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
	 * 绑定资源加载器
	 * */
	public void bindReader(SourceReader reader);
	/**
	 * 获取加载路径
	 * */
	public String getConfigPath();
	/**
	 * BeanName和对应的SourceReader
	 * */
	public static Map<String ,SourceReader> ReaderCache = new HashMap<String , SourceReader>() ;
	/**
	 * 从ReaderCache中返回Reader
	 * */
	public SourceReader getReader(String configPath);
}
