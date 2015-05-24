package com.rolando.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rolando.entity.Auto;
import com.rolando.entity.Persona;
import com.rolando.service.AutoService;
import com.rolando.service.PersonaService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		AutoService autoService = (AutoService) applicationContext.getBean(AutoService.class);
		PersonaService personaService = (PersonaService) applicationContext.getBean(PersonaService.class);

		Auto auto = (Auto) applicationContext.getBean(Auto.class);
		auto.setName("Mini");
		auto.setPatente("XXX111");
		autoService.save(auto);

		Persona persona = (Persona) applicationContext.getBean(Persona.class);
		persona.setName("Cosme");
		persona.setApellido("Fulanito");
		persona.setAuto(auto);

		personaService.save(persona);
	}
}
