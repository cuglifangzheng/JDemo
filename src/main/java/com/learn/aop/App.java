/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.aop;

/**
 *
 * @author lifangzheng
 * @version : App.java, v 0.1 2020年11月18日 2:10 下午 lifangzheng Exp $
 */
public class App {
    public void say() {
        System.out.println("App say");
    }

    @CatchException({IllegalArgumentException.class, UnsupportedOperationException.class})
    public void throwExcp() {
        System.out.println("I want to throw exception");
        throw new IllegalArgumentException("");
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.say();

        app.throwExcp();
    }
}
