/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author lifangzheng
 * @version : TimeCost.java, v 0.1 2020年11月18日 2:44 下午 lifangzheng Exp $
 */
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface CatchException {
    Class<? extends Throwable>[] value() default Throwable.class;
    boolean reThrow() default false;
}