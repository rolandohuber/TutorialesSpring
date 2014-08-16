package com.rolando.main;

import org.springframework.context.ApplicationContext;

import com.rolando.component.HelloWord;
import com.rolando.util.ApplicationContextFactory;

public class IoCSample {

	public static void main(String[] args) {

		/**
		 * Se crea un singleton del ApplicationContextFactory y del Application
		 * Context ya que solo debe haber un solo application context
		 * instanciado en toda la aplicación
		 */
		ApplicationContext applicationContext = ApplicationContextFactory.getInstance().getApplicationContext();

		/**
		 * Obtengo la clase por medio del id dado en el ApplicationContext.xml
		 * 
		 */
		{
			HelloWord word = (HelloWord) applicationContext.getBean("helloWord");
			word.sayHello();
		}

		/**
		 * Obtengo la clase indicandole el tipo de clase
		 * 
		 */
		{
			HelloWord word = (HelloWord) applicationContext.getBean(HelloWord.class);
			word.sayHello();
		}

	}
}
