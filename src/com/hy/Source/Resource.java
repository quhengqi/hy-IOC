package com.hy.Source;

import java.util.Map;

public interface Resource {
/**
 * 返回类的全局限定名
 * */
public String getClassName();
/**
 * 用来存放bean的属性及其属性值,皆以String类型存储
 * */
public Map<String , String> getValueCache();
}
