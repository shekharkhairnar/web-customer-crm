package com.customer.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	@Pointcut("execution(* com.customer.crm.controller.*.*(..))")
	public void controllerPointCut() {
		
	}
	
	@Pointcut("execution(* com.customer.crm.service.*.*(..))")
	public void servicePointCut() {
		
	}
	
	@Pointcut("execution(* com.customer.crm.dao.*.*(..))")
	public void daoPointCut() {
		
	}
	
	@Pointcut("controllerPointCut() || servicePointCut() || daoPointCut()")
	public void appFlowPointCut() {
		
	}
	
	@Before("appFlowPointCut()")
	public void beforeMehod(JoinPoint joinPoint){
		System.out.println(">>>>Entering in method :"+joinPoint.getSignature().toShortString());
	}
	
	@After("appFlowPointCut()")
	public void AfterMehod(JoinPoint joinPoint){
		System.out.println(">>>>Exited from method :"+joinPoint.getSignature().toShortString());
	}
	
	@Around("appFlowPointCut()")
	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println(">>>>Total time taken by method - "+proceedingJoinPoint.getSignature().toShortString()+" is - "+(end-start)+" ms");
		return result;
	}
}
