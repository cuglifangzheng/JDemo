/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.util.StopWatch;

/**
 *
 * @author lifangzheng
 * @version : AnnoAspect.java, v 0.1 2020年11月18日 2:11 下午 lifangzheng Exp $
 */

@Aspect
public class AnnoAspect {
    @Pointcut("execution(* com.learn.aop.App.say(..))")
    public void jointPoint() {
    }

    @Before("jointPoint()")
    public void before() {
        System.out.println("AnnoAspect before say");
    }

    @After("jointPoint()")
    public void after() {
        System.out.println("AnnoAspect after say");
    }

    @Pointcut("execution(* *.*(..)) && @annotation(com.learn.aop.TimeCost)")
    public void customAnnotation() {
    }

    @Around("customAnnotation()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().toShortString());
            return pjp.proceed();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
    }
}