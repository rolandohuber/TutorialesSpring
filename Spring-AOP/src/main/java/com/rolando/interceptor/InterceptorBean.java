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

@Aspect
@Component
public class InterceptorBean {

	@Around("execution(* com.rolando.bean.Person.*(java.lang.String))")
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

	@Before("execution(* com.rolando.bean.Person.*(java.lang.String))")
	public void logBeforeMethodCall(JoinPoint joinPoint) {
		System.out.println("@Before:Ejecutando antes de ingresar al metodo... " + joinPoint.getSignature().getName());
		System.out.println("@Before:Parametro: " + joinPoint.getTarget().toString());

	}

	@After("execution(* com.rolando.bean.Person.*(java.lang.String))")
	public void logAfterMethodCall(JoinPoint joinPoint) {
		System.out.println("@After:Ejecutando after..." + joinPoint.getSignature().getName());

	}

	@AfterThrowing(pointcut = "execution(* com.rolando.bean.Person.*(java.lang.String))", throwing = "ex")
	public void hayUnError(JoinPoint joinPoint, Exception ex) {
		System.out.println("@AfterThrowing:Hay un error" + ex.getMessage());
		ex.printStackTrace();
	}

	@AfterReturning(pointcut = "execution(* com.rolando.bean.Person.*(java.lang.String))", returning = "response")
	public void logAfterReturningCall(JoinPoint joinPoint, Object response) {
		System.out.println("@AfterReturning:AfterReturning after..." + joinPoint.getSignature().getName());
		System.out.println("Response data :" + response);
		// verificar si puedo modificar el resultado Final
	}

}
