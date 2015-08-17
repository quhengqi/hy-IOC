package com.hy.Logger;

public class DefaultLogger implements Logger{
	public static boolean show = true;
	public DefaultLogger(){

	}
	public DefaultLogger(boolean lock){
		setLock(lock);
	}
	public static boolean isShow() {
		return show;
	}
	public static void setLock(boolean show) {
		DefaultLogger.show = show;
	}
	public void log(String str){
		if(show){
			System.out.println("LOG:"+str);
		}

	}
}
