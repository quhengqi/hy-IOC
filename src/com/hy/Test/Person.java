package com.hy.Test;

public class Person {
private String name;
private int age;
private boolean flag;
private double money;
private long date;
private short ID;
private char sex;
private byte buffer;
public boolean isFlag() {
	return flag;
}
public void setFlag(boolean flag) {
	this.flag = flag;
}
public double getMoney() {
	return money;
}
public void setMoney(double money) {
	this.money = money;
}
public long getDate() {
	return date;
}
public void setDate(long date) {
	this.date = date;
}
public short getID() {
	return ID;
}
public void setID(short iD) {
	ID = iD;
}
public Person(){
	
}
public String getName() {
	return name;
}
public Person(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public char getSex() {
	return sex;
}
public void setSex(char sex) {
	this.sex = sex;
}
public byte getBuffer() {
	return buffer;
}
public void setBuffer(byte buffer) {
	this.buffer = buffer;
}
}
