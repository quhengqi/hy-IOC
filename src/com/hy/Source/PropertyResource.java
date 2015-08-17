package com.hy.Source;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.hy.Reader.PropertySourceReader;
import com.hy.Reader.SourceReader;
@SuppressWarnings("static-access")
public class PropertyResource implements Resource{
	/**
	 * 资源读取器
	 * */
	private Properties property;
	/**
	 * 	资源流加载器
	 * */
	private SourceReader reader;
	/**
	 * Property+Value缓存
	 * */
	private  Map<String , String> ValueCache ; 
	/**
	 * 默认构造器
	 * */
	public PropertyResource(){
		property = new Properties();
		ValueCache = new HashMap<String , String>();
		logger.log("创建新的资源:"+this);
	}
	/**
	 * 如果是直接使用configPath创建
	 * 则不传入资源加载器
	 * */
	public PropertyResource(String configPath){
		this(configPath ,null);

	}
	/**
	 * 如果使用资源加载器创建新的实例
	 * 传入该资源加载器以避免二次创建资源加载器
	 * */
	public PropertyResource(SourceReader exitReader){
		this(exitReader.getConfigPath() , exitReader);

	}

	private PropertyResource(String configPath,SourceReader exitReader){
		this();
		if(exitReader == null){
			reader = new PropertySourceReader(configPath);
		}else{
			reader = exitReader;
		}
		init(configPath);
	}
	private void init(String configPath){
		try {
			property.load(reader.getStream());
			for(Object key : property.keySet()){
				//				System.out.println(key+property.getProperty(key.toString()));
				ValueCache.put(key.toString() , RemoveSign(property.getProperty(key.toString())));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			logger.log("资源[ "+configPath+" ]加载成功");
			reader.closeIO();
		}
	}
	@Override
	/**
	 * 从ValueCache中获取class的全局限定名
	 * */
	public String getClassName() {
		// TODO Auto-generated method stub
		return ValueCache.get("class");
	}
	@Override
	/**
	 * 获得ValueCache缓存
	 * */
	public Map<String, String> getValueCache() {
		// TODO Auto-generated method stub
		return this.ValueCache;
	}
	/**
	 * 去除属性两边双引号操作
	 * @param="test"
	 * @return=test
	 * */
	private String RemoveSign(String valueTemp) {
		if(valueTemp.startsWith("\"")){
			return new StringBuilder(valueTemp).substring(1,valueTemp.length()-1);
		}
		return valueTemp;
	}
	@Override
	/**
	 * 绑定资源读取器
	 * */
	public void bindReader(SourceReader reader){
		this.reader = reader;
	}
	@Override
	/**
	 * 获取资源读取器的读取的资源的路径
	 * */
	public String getConfigPath() {
		// TODO Auto-generated method stub
		return reader.getConfigPath();
	}
	@Override
	public String getBeanName() {
		// TODO Auto-generated method stub
		return ValueCache.get("beanName");
	}
}
