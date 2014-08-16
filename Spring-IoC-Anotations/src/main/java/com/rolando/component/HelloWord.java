package com.rolando.component;

import org.springframework.stereotype.Component;

/**
 *  @Component: con este tag le indicamos que es un bean y se debe incluir en el ApplicationContext
 *				value: es el id que quiero que tenga el component, por defecto es el nombre de la clase con la primer letra en minuscula 
 */
@Component
public class HelloWord{
	
	public void sayHello(){
		System.out.println("Hello from HelloWordImpl.class");
	}

}
