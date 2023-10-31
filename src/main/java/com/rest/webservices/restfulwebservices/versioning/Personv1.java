package com.rest.webservices.restfulwebservices.versioning;

public class Personv1 {
	private String name;

	public Personv1(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
	
	
}
