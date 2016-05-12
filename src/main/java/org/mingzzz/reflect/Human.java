package org.mingzzz.reflect;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Resource
public class Human {
	public String HUMAN_PACKAGE = "org.mingzzz.reflect.Human";
	
	private String name;
	private String sex;
	private String age;
	
	public Human() {}

	public Human(String name) {
		this.name = name;
	}
	
	public void run() { System.out.println("Running"); };
	
	public void speak() { System.out.println("Speaking"); }
	
	public List<String> testReflectList(){
		List<String> testList = new ArrayList<String>();
		testList.add("123");
		
		return testList;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
