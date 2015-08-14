package com.hy.Reader;

import java.io.InputStream;

public interface SourceReader {
/**
 * 获取加载类的资源流
 * */
public InputStream getStream();
/**
 * 绑定资源
 * */
public void bingConfigPath(String Path);
}
