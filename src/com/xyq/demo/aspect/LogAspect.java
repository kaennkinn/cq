package com.xyq.demo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private static Logger logger = Logger.getLogger(LogAspect.class);
	@Before(value = "execution(* com.xyq.demo.service.*.*(..))")
	public void printBefore(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		logger.info(methodName+"メソッド開始時間："+System.currentTimeMillis());
	}
	
	@After(value = "execution(* com.xyq.demo.service.*.*(..))")
	public void printAfter(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		logger.info(methodName+"メソッド終了時間："+System.currentTimeMillis());
	}
	
	@AfterReturning(value="execution(* com.xyq.demo.service.impl.*.*(..))",returning="result")
	public void printReturn(JoinPoint jp,Object result) {
		String methodName = jp.getSignature().getName();
		logger.info(methodName+"メソッド結果:"+result);
	}
}
