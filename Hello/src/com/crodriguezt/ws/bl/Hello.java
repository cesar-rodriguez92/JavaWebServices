package com.crodriguezt.ws.bl;

public class Hello {

	public String helloName(String name){
		System.out.println("LLega el nombre de: " +name + "<------");
		return "Hello there " + name;
	}
}
