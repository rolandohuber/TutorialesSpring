package com.rolando.bean;

import org.springframework.stereotype.Component;

@Component
public class Person {
	public String sayHello(String texto) throws Exception {
		System.out.println("Saludando " + texto);
		return "Respuesta";
	}
}
