package com.hy.Reader;

import java.io.IOException;
import java.io.InputStream;

public class SourceReader implements Reader {
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
	public SourceReader(){
		logger.log("创建新的资源加载器Bean:"+this);
	}
	/**
	 * 非默认构造器
	 * */
	public SourceReader(String configPath){
		this();
		this.configPath =configPath;
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
		logger.log("读取配置 ["+configPath+" ]成功");
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
	public String getConfigPath() {
		return this.configPath;
	}
	@Override
	public void closeIO() {
		// 判空操作
		if(is!= null)
			try {
				is.close();
				logger.log("已关闭资源流");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
