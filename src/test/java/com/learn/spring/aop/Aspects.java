/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.learn.spring.aop;

import com.alipay.common.tracer.util.TracerContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.MDC;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.testng.annotations.AfterMethod;

/**
 *
 * @author lifangzheng
 * @version $Id: NotVeryUsefulAspect.java, v 0.1 2019年09月25日 20:42 lifangzheng Exp $
 */
@Aspect
@EnableAspectJAutoProxy
public class Aspects {

    //@Before("execution(* com.learn.spring.aop.FeatureCalImpl.*(..))")
    //public void addTraceId() {
    //    MDC.put("traceId", TracerContextUtil.getTraceId());
    //}
    //
    //@After("execution(* com.learn.spring.aop.FeatureCalImpl.*(..))")
    //public void removeTraceId() {
    //    MDC.remove("traceId");
    //}

    @Around("execution(* com.learn.spring.aop.FeatureCalImpl.*(..))")
    public void processAuthority (ProceedingJoinPoint point)throws Throwable{
        MDC.put("traceId", TracerContextUtil.getTraceId());
        System.out.println("EXECUTION welcome");
        System.out.println("EXECUTION 调用方法:" + point.getSignature().getName());
        System.out.println("EXECUTION 目标对象：" + point.getTarget());
        System.out.println("EXECUTION 首个参数：" + point.getArgs()[0]);
        point.proceed();
        System.out.println("EXECUTION success");
        MDC.remove("traceId");
    }

}