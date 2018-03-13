package com.weicheng.ioc.config;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
	
	private String name;
	private int age;
	private Hand hand;
	private String[] sonNameArr;
	private List<String> sonNameList;
	private Map<String,String> sonNameMap;
	private Properties sonNameProp;
	
	public User() {
		
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHand(Hand hand){
		this.hand = hand;
	}
	
	public void setSonNameArr(String[] sonNameArr) {
		this.sonNameArr = sonNameArr;
	}

	public void setSonNameList(List<String> sonNameList) {
		this.sonNameList = sonNameList;
	}

	public void setSonNameMap(Map<String, String> sonNameMap) {
		this.sonNameMap = sonNameMap;
	}

	public void setSonNameProp(Properties sonNameProp) {
		this.sonNameProp = sonNameProp;
	}

	public void use(){
		System.out.println("User(" + name + "," + age + "Ëê):use...");
	}
	
	public void eat(){
		if(hand != null) hand.eat();
	}
	
	public void printSons(){
		System.out.print("sonNameArr:");
		for(String name:sonNameArr) System.out.print(name + " ");
		System.out.println("");
		System.out.println("sonNameList:" + sonNameList);
		System.out.println("sonNameMap:" + sonNameMap);
		System.out.println("sonNamePrts:" + sonNameProp);
	}

}
