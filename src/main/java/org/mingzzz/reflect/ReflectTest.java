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
	 * ģ���ȡһ���������public�����������뷽��������
	 * ���Կ���������һЩ�����Լ�����ķ������������Object�ķ���Ҳ����ӡ�˳���
	 * @author Ming
	 * @date 2016-5-12 ����12:10:42
	 */
	public static void getMethods(){
		try{		
			// ��ӡ��ָ���������public����,��������
			Method[] methods = Human.class.getMethods();
			for (Method method: methods){
				System.out.println("method = " + method.getName());
			}
			
			// ��ȡָ�����ֵķ���������ִ��֮
			Method  method = Human.class.getMethod("setName", String.class);
			Human human = new Human();
			method.invoke(human, "kaka");
			System.out.println(human.getName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ������Ի�ȡһ����ĺܶණ��������������������������Ϣ��������ʵ�ֵĽӿڣ����η���ע���
	 * ������ͳ��Ի�ȡ���ע��
	 * @author Ming
	 * @date 2016-5-12 ����12:16:48
	 */
	public static void getAnno(){
		Annotation[] annotations = Human.class.getAnnotations();
		for (Annotation anno: annotations){
			System.out.println("anno = " + anno.annotationType());
		}
	}
	
	/**
	 * ��ȡ��Ĺ��캯��,���ҿ���ͨ�����캯����ʵ����һ����
	 * @author Ming
	 * @date 2016-5-12 ����12:27:49
	 */
	public static void getConstructor(){
		try{
			// ��ȡ���캯��
			Constructor constructor = Human.class.getConstructor(String.class);
			// ͨ�����캯��ʵ��������
			Human human = (Human) constructor.newInstance("С��");
			
			System.out.println(human.getName());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getFields(){
		try {
			//��ȡ�������е�public����
			Field[] fields =  Human.class.getFields();
			for (Field field: fields){
				System.out.println("public == fieldName = " + field.getName() + " ====== fieldType = " + field.getType());
			}
			
			//��ȡ���е�����private����
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
