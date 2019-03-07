package com.okta.assignment;

public class Customer {
	protected String name;
	
	public Customer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Customer(" + name + ")";
	}
}
