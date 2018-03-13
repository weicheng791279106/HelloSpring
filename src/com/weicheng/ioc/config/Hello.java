package com.weicheng.ioc.config;

public class Hello {

	/**
	 * spring的xml配置方式实现IOC操作演示
	 * 
	 * 本示例中主要演示以下相关知识点：
	 * 	1、使用无参构造方法创建对象（重点）
	 * 	2、使用静态工厂创建对象
	 * 	3、使用普通工厂创建对象
	 * 	4、scope属性的singleton及prototype属性值演示
	 * 	5、属性注入（重点）
	 * 
	 * xml实现ioc操作步骤：
	 * 	1、导入spring基础jar包
	 * 	2、编写需要生成的类
	 * 	3、创建spring配置文件，引入schema约束，配置创建类
	 * 	4、编写测试代码
	 * 
	 * <bean>标签中的常用属性：
	 * 	1、id：名称，任意命名，不能包含特殊符号，根据id值得到配置对象
	 * 	2、class：需要创建的对象所在类的全路径
	 * 	3、name：功能和id属性一样，可以包含特殊符号，为了兼容旧版本spring框架而存在，基本不使用
	 * 	4、scope：bean的作用范围，常用的有两个属性值：
	 * 		(1)singleton：单例（默认值）
	 * 		(2)prototype：多例
	 * 
	 * 属性注入：在创建对象的时候，想对象中的属性设置值
	 * 
	 * 属性注入的三种方式（spring只支持1、2方式）：
	 * 	1、set方法注入（重点）
	 * 	2、有参构造方法注入
	 * 	3、接口注入
	 * 
	 * 属性注入的类型：
	 * 	1、普通属性
	 * 	2、对象属性
	 * 	3、复杂属性（array、list、map、properties）
	 * 
	 * */
	
}
