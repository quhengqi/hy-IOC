package com.hy.Reader;

import java.io.InputStream;

import com.hy.Logger.Logger;

public interface SourceReader extends Logger{
/**
 * 获取加载类的资源流
 * */
public InputStream getStream();
/**
 * 返回资源路径
 * */
public String getConfigPath();
/**
 * 关闭资源流
 * */
public void closeIO();
}
