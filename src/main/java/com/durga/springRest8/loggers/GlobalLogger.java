package com.durga.springRest8.loggers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile(value= {"h2","mysql","postgrees","default"})
public class GlobalLogger {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(GlobalLogger.class);
	@Pointcut("execution (* com.durga.springRest8..*(..))")
	public void pointcut() {
		
	}
	@Before("pointcut()")
	public void before(JoinPoint joinpoint) {
		LOGGER.info("start->>"+joinpoint.getSignature());
	}
	@AfterThrowing(pointcut="pointcut()",throwing="error")
	public void afterThrowing(JoinPoint joinpoint,Exception error) {
		LOGGER.error(error.getMessage(),error);
	}

}
