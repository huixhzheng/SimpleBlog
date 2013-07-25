package com.duell.logging.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class PerformanceLoggingAdvice implements MethodBeforeAdvice,
		AfterReturningAdvice {

	long startTime = 0;
	long finishTime = 0;
	
	protected static final Logger log = Logger
			.getLogger(PerformanceLoggingAdvice.class);

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {

		startTime = System.currentTimeMillis();
		log.debug("Executing method " + method.getName() + "on object " + target.getClass().getName());
	}

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {

		finishTime = System.currentTimeMillis();
		double totalDuration = finishTime - startTime;
		
		String message = String.format("Finished executing method %s on object %s in %lf seconds",method.getName(),target.getClass().getName(),totalDuration/1000);
		log.debug(message);
//		log.debug("Finished executing method "+ method.getName() + " on object " + target.getClass().getName()
//				+ " in " + totalDuration / 1000 + "seconds");
	}

}
