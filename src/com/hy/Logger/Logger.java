package com.hy.Logger;

public interface Logger {
	/**
	 * 日志
	 * true则输出日志文件
	 * false不输出日志文件
	 * */
	public static DefaultLogger logger = new DefaultLogger(true);
	
}
