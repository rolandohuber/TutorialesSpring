package com.rolando.main;

import org.springframework.context.ApplicationContext;

import com.rolando.component.HelloWord;
import com.rolando.component.Persona;
import com.rolando.util.ApplicationContextFactory;

public class IoCSample {

	public static void main(String[] args) {

		ApplicationContext applicationContext = ApplicationContextFactory.getInstance().getApplicationContext();
		{
			HelloWord helloWord = (HelloWord) applicationContext.getBean("helloWord");
			helloWord.sayHello();
		}

		{
			HelloWord helloWord = (HelloWord) applicationContext.getBean(HelloWord.class);
			helloWord.sayHello();
		}

		{
			Persona persona = (Persona) applicationContext.getBean("persona");
			persona.getName();
		}

		{
			Persona persona = (Persona) applicationContext.getBean(Persona.class);
			persona.getName();
		}
	}
}
