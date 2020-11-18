/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
}