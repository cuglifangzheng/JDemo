package com.learn.java8.stream;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther: lifangzheng
 * @date: 18/12/11 18:58
 * @description:
 */
public class StreamTest {
    private List<String> wordList = Arrays.asList("a", "b", "c");
    ReadWriteLock lock = new ReentrantReadWriteLock();
    @Test
    public void mapTest() {
        List<String> outPut = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());
        outPut.stream().forEach(System.out::println);
    }

    @Test
    public void test() {
        lock.readLock().lock();
        System.out.println(new StreamTest().toString());
    }

    @Override
    public String toString() {
        return "StreamTest{" +
                "wordList=" + wordList +
                '}';
    }

    @Test
    public void testReduce() {
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6);
        /**
         * 求和，也可以写成Lambda语法：
         * Integer sum = s.reduce((a, b) -> a + b).get();
         */
        //Integer sum = s.reduce(10, (a, b) -> a+b);
        //
        //System.out.println("sum:" + sum);

        System.out.println(Stream.of(1, 2, 3).parallel().reduce(4,
                (integer, integer2) -> integer + integer2
                , (integer, integer2) -> integer * integer2));
    }
}
