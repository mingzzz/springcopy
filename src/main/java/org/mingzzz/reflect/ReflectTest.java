package org.mingzzz.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ReflectTest {
	public static void main(String[] args) {
		//getMethods();
		//getAnno();
		//getConstructor();
		//getFields();
		getListReturnType();
	}
	
	/**
	 * 模拟获取一个类的所有public方法，并输入方法的名字
	 * 可以看到，除了一些我们自己定义的方法，连父类的Object的方法也被打印了出来
	 * @author Ming
	 * @date 2016-5-12 上午12:10:42
	 */
	public static void getMethods(){
		try{		
			// 打印出指定类的所有public方法,包括父类
			Method[] methods = Human.class.getMethods();
			for (Method method: methods){
				System.out.println("method = " + method.getName());
			}
			
			// 获取指定名字的方法，并且执行之
			Method  method = Human.class.getMethod("setName", String.class);
			Human human = new Human();
			method.invoke(human, "kaka");
			System.out.println(human.getName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 反射可以获取一个类的很多东西，包括但不限于类名，包信息，方法，实现的接口，修饰符，注解等
	 * 在这里就尝试获取类的注解
	 * @author Ming
	 * @date 2016-5-12 上午12:16:48
	 */
	public static void getAnno(){
		Annotation[] annotations = Human.class.getAnnotations();
		for (Annotation anno: annotations){
			System.out.println("anno = " + anno.annotationType());
		}
	}
	
	/**
	 * 获取类的构造函数,并且可以通过构造函数来实例化一个类
	 * @author Ming
	 * @date 2016-5-12 上午12:27:49
	 */
	public static void getConstructor(){
		try{
			// 获取构造函数
			Constructor constructor = Human.class.getConstructor(String.class);
			// 通过构造函数实例化对象
			Human human = (Human) constructor.newInstance("小猴");
			
			System.out.println(human.getName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getFields(){
		try {
			//获取类中所有的public变量
			Field[] fields =  Human.class.getFields();
			for (Field field: fields){
				System.out.println("public == fieldName = " + field.getName() + " ====== fieldType = " + field.getType());
			}
			
			//获取类中的所有private变量
			Field[] privateFields = Human.class.getDeclaredFields();
			for (Field pfield: privateFields){
				System.out.println("private == fieldName = " + pfield.getName() + " ====== fieldType = " + pfield.getType());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getListReturnType(){
		try{
			Method method = Human.class.getMethod("testReflectList", null);
			Type returnType = method.getGenericReturnType();
			
			if (returnType instanceof ParameterizedType){
				ParameterizedType type = (ParameterizedType) returnType;
				Type[] typeArguments = type.getActualTypeArguments();
				for (Type typeArgument: typeArguments){
					Class typeArgClass = (Class) typeArgument;
					System.out.println("typeArgClass = " + typeArgClass.getName());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
