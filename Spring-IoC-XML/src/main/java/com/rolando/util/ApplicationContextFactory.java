package com.rolando.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextFactory {

	private ApplicationContext applicationContext;
	private static ApplicationContextFactory instance;

	private ApplicationContextFactory() {
		/**
		 * Con esto le indicamos a Spring que levante las configuraciones desde
		 * el ApplicationContext.xml
		 */
		applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}

	/**
	 * 
	 * @return
	 */
	public static ApplicationContextFactory getInstance() {

		if (instance == null)
			instance = new ApplicationContextFactory();

		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public ApplicationContext getApplicationContext() {

		return applicationContext;
	}

}
