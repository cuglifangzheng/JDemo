/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.aop;

/**
 *
 * @author lifangzheng
 * @version : CostTest.java, v 0.1 2020年11月18日 2:45 下午 lifangzheng Exp $
 */
public class CostTest {
    @TimeCost
    public void cost() throws Exception {
        Thread.sleep(1000);
    }
}