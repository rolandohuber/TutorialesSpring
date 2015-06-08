package com.rolando.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Aspect con esta anotacion le decimos que va a ser una clase que tendra
 *         funcionalidad cross a varios metodos o clases
 * @author rolando.huber
 *
 */
@Aspect
@Component
public class InterceptorBean {

	/*
	 * execution(* com.rolando.bean.Person.sayHello(java.lang.String))
	 * 
	 * execution le dice que este metodo se ejecutara cuando el metodo sayHello
	 * de la clase Person sea llamado, y que dicho metodo recibe un string como
	 * parametro.
	 */

	@Around("execution(* com.rolando.bean.Person.sayHello(java.lang.String))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("@Around:Ejecutando inicio Around...");
		System.out.println("@Around:Objeto: " + pjp.getTarget().toString());
		System.out.println("@Around:Nombre del Metodo: " + pjp.getSignature().getName());

		String nuevoTexo = "(De donde salio esto?)";
		if (pjp.getArgs() != null && pjp.getArgs().length > 0) {
			for (Object arg : pjp.getArgs()) {
				System.out.println("Modificando el parametro original...");
				System.out.println("Argumento Original: " + arg);
			}
		}
		Object output = pjp.proceed(new String[] { nuevoTexo });
		System.out.println("@Around:fin Around...");

		return output;
	}

	@Before("execution(* com.rolando.bean.Person.sayHello(java.lang.String))")
	public void logBeforeMethodCall(JoinPoint joinPoint) {
		System.out.println("@Before:Ejecutando antes de ingresar al metodo... " + joinPoint.getSignature().getName());
		System.out.println("@Before:Parametro: " + joinPoint.getTarget().toString());

	}

	/*
	 * execution(* com.rolando.bean.Person.*(java.lang.String))
	 * 
	 * lo que cambia aca es la terminacion del "nombre del metodo" ( .* ) con
	 * esto le dice que se ejecute en cualquier metodo de la clase person que
	 * reciba un String como parametro
	 */
	@After("execution(* com.rolando.bean.Person.*(java.lang.String))")
	public void logAfterMethodCall(JoinPoint joinPoint) {
		System.out.println("@After:Ejecutando after..." + joinPoint.getSignature().getName());

	}

	@AfterThrowing(pointcut = "execution(* com.rolando.bean.Person.*(java.lang.String))", throwing = "ex")
	public void hayUnErrorNoEjecuta(JoinPoint joinPoint, Exception ex) {
		System.out.println("@AfterThrowing:Hay un error" + ex.getMessage());
		ex.printStackTrace();
	}

	/*
	 * execution(* com.rolando.bean.Person.*(java.lang.String))
	 * 
	 * lo que cambia aca son los parametros ( vacio ) con esto le dice que se
	 * ejecute en cualquier metodo de la clase person que no reciba ningun
	 * parametro
	 */
	@AfterThrowing(pointcut = "execution(* com.rolando.bean.Person.*())", throwing = "ex")
	public void hayUnError(JoinPoint joinPoint, Exception ex) {
		System.out.println("@AfterThrowing:Hay un error :" + ex.getMessage());
	}

	@AfterReturning(pointcut = "execution(* com.rolando.bean.Person.*(java.lang.String))", returning = "response")
	public void logAfterReturningCall(JoinPoint joinPoint, Object response) {
		System.out.println("@AfterReturning:AfterReturning after..." + joinPoint.getSignature().getName());
		System.out.println("Response data :" + response);
		// verificar si puedo modificar el resultado Final, al parecer no.
	}

	/**
	 * Algunos ejemplos de como indicarle cuando queremos que se ejecute el
	 * metodo:
	 * 
	 * se ejecutara para cualquier metodo publico dentro del proyecto
	 * execution(public * *(..))
	 * 
	 * se ejecutara en cualquier metodo que empiece con la palabra set
	 * execution(* set*(..))
	 * 
	 * para cualquier metodo definido dentro de la clase AccountService o de ser
	 * una interfaz, lo mismo pero para cualquier implementacion execution(*
	 * com.xyz.service.AccountService.*(..))
	 * 
	 * se ejecuta en cualquier metodo de cualquier clase del paquete service
	 * execution(* com.xyz.service.*.*(..))
	 * 
	 * se ejecuta en cualquier metodo de cualquier clase del paquete service o
	 * en sub-paquetes del mismo: execution(* com.xyz.service..*.*(..))
	 */

}
