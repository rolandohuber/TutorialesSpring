package com.rolando.bean;

import org.springframework.stereotype.Component;

@Component
/**
 * Es el bean con el cual vamos a interactuar, trabajaremos con los metodos de esta clase.
 *  @author rolando.huber
 *
 */
public class Person {
	/**
	 * 
	 * @param texto
	 * @return
	 * @throws Exception
	 */
	public String sayHello(String texto) throws Exception {
		System.out.println("Saludando " + texto);
		return "Respuesta";
	}

	/**
	 * Con este metodo probaremos como ejecutar algo al momento que se lanza una
	 * excepcion
	 * 
	 * @throws Exception
	 */
	public void throwExeption() throws Exception {
		throw new Exception("Mi excepcion");
	}

}
