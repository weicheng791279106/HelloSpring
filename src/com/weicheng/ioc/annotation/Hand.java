package com.weicheng.ioc.annotation;

import org.springframework.stereotype.Component;

@Component("hand")
public class Hand {

	public void eat(){
		System.out.println("eat with hand...");
	}
	
}
