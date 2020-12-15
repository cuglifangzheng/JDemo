/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.learn.enhance;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author lifangzheng
 * @version : EnhanceTest.java, v 0.1 2020年12月01日 4:24 下午 lifangzheng Exp $
 */
public class EnhanceTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                System.out.println("before");
                Object res = methodProxy.invokeSuper(obj, args);
                //Object res = method.invoke(obj, args);
                System.out.println("after");
                return res;
            }
        });
        Car car = (Car) enhancer.create(new Class[]{String.class}, new Object[]{"audi"});
        car.print();
    }

    static class Car {
        private String name;

        public Car(String name) {
            this.name = name;
        }

        void print() {
            System.out.println("I am a car, named:" + name);
        }
    }
}