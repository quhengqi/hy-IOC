package com.hy.Source;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.hy.Reader.Reader;


public class XMLResource implements Resource {
	/**
	 * 资源读取器
	 * */
	private Document document;
	/**
	 * 	资源流加载器
	 * */
	private SAXReader reader;
	/**
	 * Property+Value缓存
	 * */
	private  Map<String , String> ValueCache ; 
	/**
	 * 默认构造器
	 * */
	public XMLResource(){
		reader = new SAXReader();
		ValueCache = new HashMap<String , String>();
		logger.log("创建新的资源Bean:"+this);
	}
	/**
	 * 如果是直接使用configPath创建
	 * 则不传入资源加载器
	 * */
	public XMLResource(String configPath){
		this(configPath,true ,null);

	}
	/**
	 * 如果使用资源加载器创建新的实例
	 * 传入该资源加载器以避免二次创建资源加载器
	 * */
	public XMLResource(Reader exitReader){
		this(exitReader.getConfigPath() ,false, exitReader);

	}

	@SuppressWarnings("unused")
	private XMLResource(String configPath,boolean needCreateReader,Reader exitReader){
		try {
			document = reader.read(new File(configPath));
			Element root = document.getRootElement();

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return ValueCache.get("class");
	}

	@Override
	public String getBeanName() {
		// TODO Auto-generated method stub
		return ValueCache.get("beanName");
	}

	@Override
	public Map<String, String> getValueCache() {
		// TODO Auto-generated method stub
		return this.ValueCache;
	}

	@Override
	public String getConfigPath() {
		// TODO Auto-generated method stub
		return ((Reader) reader).getConfigPath();
	}

}
