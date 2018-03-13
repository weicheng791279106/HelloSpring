package com.weicheng.ioc.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**注解创建单例对象演示*/
@Component("singletonUser")
@Scope("singleton")
public class SingletonUser {

}
