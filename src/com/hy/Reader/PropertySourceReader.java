package com.hy.Reader;

import java.io.InputStream;

public class PropertySourceReader implements SourceReader {
	/**
	 * 资源路径
	 * */
	private String configPath;
	/**
	 * 资源加载流
	 * */
	private InputStream is;
	/**
	 * 默认构造器
	 * */
	public PropertySourceReader(){
	}
	/**
	 * 非默认构造器
	 * */
	public PropertySourceReader(String configPath){
		bingConfigPath(configPath);
		init();
	}
	/**
	 * 资源初始化方法
	 * */
	private void init() {
		try{
			is= ClassLoader.getSystemResourceAsStream(configPath);
		}
		catch(Exception ex){
			System.out.println("资源加载发生异常,请检查路径["+configPath+"]是否填写正确");
		}
	}
	@Override
	public InputStream getStream() {
		//返回资源加载流
		if(is == null ){
			init();
		}
		return is;
	}

	@Override
	public void bingConfigPath(String configPath) {
		// TODO Auto-generated method stub
		this.configPath = configPath;
	}
}
