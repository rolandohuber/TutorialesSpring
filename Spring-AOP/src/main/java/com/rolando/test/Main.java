package com.rolando.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rolando.bean.Person;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person holaMundo = (Person) appContext.getBean(Person.class);

		try {
			String response = holaMundo.sayHello(" El texto original");
			System.out.println("Respuesta Final del Metodo :" + response);
			holaMundo.throwExeption();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
