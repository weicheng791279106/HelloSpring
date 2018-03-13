package com.weicheng.ioc.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**注解创建多实例对象演示*/
@Component("prototypeUser")
@Scope("prototype")
public class PrototypeUser {

}
