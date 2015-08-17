package com.hy.Test;

public class Car {
private double weight;
private double price;
private String factroy;
private String brand;
private int number;
@Override
public String toString() {
	return "Car [weight=" + weight + ", price=" + price + ", factroy=" + factroy + ", brand=" + brand + ", number="
			+ number + "]";
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getFactroy() {
	return factroy;
}
public void setFactroy(String factroy) {
	this.factroy = factroy;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
}
