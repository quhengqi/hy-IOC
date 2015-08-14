package com.hy.Source;

import java.util.Map;

public interface Resource {
/**
 * 返回类的全局限定名
 * */
public String getClassName();

public Map<String , String> getValueCache();
}
