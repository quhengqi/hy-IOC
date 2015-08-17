package com.hy.Logger;

public class DefaultLogger implements Logger{
	public static boolean lock = true;
	public DefaultLogger(){

	}
	public DefaultLogger(boolean lock){
		setLock(lock);
	}
	public static boolean isLock() {
		return lock;
	}
	public static void setLock(boolean lock) {
		DefaultLogger.lock = lock;
	}
	public static void log(String str){
		if(lock){
			System.out.println("LOG:"+str);
		}

	}
}
