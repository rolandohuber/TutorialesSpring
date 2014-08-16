package com.rolando.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  @Component: con este tag le indicamos que es un bean y se debe incluir en el ApplicationContext
 *				value: es el id que quiero que tenga el component, por defecto es el nombre de la clase con la primer letra en minuscula 
 */
@Component
public class Persona {
	/**
	 * @Autowired con este tag evito usar el applicationContext.getBean y le digo que cuando se instancie la clase me inyecte automaticamente la clase solicitada
	 * 				required: si es requerido o no 
	 */
	@Autowired
	private Casa casa;

	public void getName() {
		System.out.println("My name is PEPE!!");
		casa.getDireccion();
	}
}
