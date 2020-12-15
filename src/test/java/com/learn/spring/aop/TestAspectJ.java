/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.spring.aop;

import com.learn.aop.CatchException;
import org.testng.annotations.Test;

/**
 *
 * @author lifangzheng
 * @version : TestAspectJ.java, v 0.1 2020年11月26日 8:17 下午 lifangzheng Exp $
 */
public class TestAspectJ {
    static class ThrowExceptTest {
        @CatchException
        public void test() {
            throw new RuntimeException("test");
        }
    }

    @Test
    public void test() {
        ThrowExceptTest throwExceptTest = new ThrowExceptTest();
        throwExceptTest.test();
    }
}