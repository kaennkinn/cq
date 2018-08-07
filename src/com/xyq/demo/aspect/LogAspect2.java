package com.xyq.demo.aspect;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LogAspect2 {

	private static Logger logger = Logger.getLogger(LogAspect2.class);
//	@Before(value = "execution(* com.xyq.demo.service.*.*(..))")
	public void printBefore(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		logger.info(methodName+"メソッド開始：11111111111111111");
	}
	
//	@After(value = "execution(* com.xyq.demo.service.*.*(..))")
	public void printAfter(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		logger.info(methodName+"メソッド終了時間："+System.currentTimeMillis());
	}
	
//	@AfterReturning(value="execution(* com.xyq.demo.service.impl.*.*(..))",returning="result")
	public void printReturn(JoinPoint jp,Object result) {
		String methodName = jp.getSignature().getName();
		logger.info(methodName+"メソッド結果:"+result);
	}
	
	/*public Object printAround(ProceedingJoinPoint pjp) {
		String methodName = pjp.getSignature().getName();
		Object result = null;
		try {
			//前置通知
			logger.info(methodName + "メソッド開始時間：" + new Date());
			result = pjp.proceed();
			//返回通知
			logger.info(methodName+""+result);
		} catch (Throwable e) {
			e.printStackTrace();
			//异常通知
			logger.info(methodName+""+e.getMessage());
		} finally {
			//后置通知
			logger.info(methodName + "メソッド終了時間：" + new Date());
		}
		
		return result;
	}*/
	
}
