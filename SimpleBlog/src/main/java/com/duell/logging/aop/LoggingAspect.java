package com.duell.logging.aop;


import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	Logger logger = Logger.getLogger(LoggingAspect.class);

	@Around("execution(* com.duell.blogging.view.converter.*.*(..))")
	public Object converterLogger(ProceedingJoinPoint joinPoint)
			throws Throwable {
		return doStuff(joinPoint);
	}

	protected Object doStuff(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		
		String methodName = joinPoint.getSignature().getName();
		String preMessage = String.format("Service Class: %s Method: %s. Arguments={%s}",joinPoint.getTarget(),
				methodName, Arrays.toString(joinPoint.getArgs()));

		logger.debug(preMessage);
		Object rVal = null;
		try {
			rVal = joinPoint.proceed();
			return rVal;
		} finally {
			long endTime = System.currentTimeMillis();
			double duration = endTime - startTime;
			String postMessage = String.format(
					"Service method: %s. Duration:%.0f(ms). Return Value=%s",
					methodName, duration, rVal);

			logger.debug(postMessage);
		}
	}

	@Around("execution(* com.duell.blogging.service.*.*(..))")
	public Object serviceLogger(ProceedingJoinPoint joinPoint) throws Throwable {
		return doStuff(joinPoint);

	}
}
