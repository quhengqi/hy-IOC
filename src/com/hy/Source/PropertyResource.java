package com.hy.Source;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.hy.Reader.PropertySourceReader;

public class PropertyResource implements Resource{
	/**
	 * 资源读取器
	 * */
	private Properties property;
	/**
	 * 	资源流读取器
	 * */
	private PropertySourceReader reader;
	/**
	 * Property+Value缓存
	 * */
	public  Map<String , String> ValueCache = null; 
	
	public PropertyResource(){

	}
	public PropertyResource(String configPath){
		ValueCache = new HashMap<String , String>();
		property = new Properties();
		reader = new PropertySourceReader(configPath);
		init();
	}
	public void init(){
		try {
			property.load(reader.getStream());
			for(Object key : property.keySet()){
//				System.out.println(key+property.getProperty(key.toString()));
				ValueCache.put(key.toString() , RemoveSign(property.getProperty(key.toString())));
			}
		} catch (IOException e) {
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
}
