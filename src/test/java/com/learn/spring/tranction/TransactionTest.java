/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.learn.spring.tranction;

import com.learn.spring.aop.FeatureCalImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 *
 * @author lifangzheng
 * @version $Id: TransactionTest.java, v 0.1 2019年09月25日 19:34 lifangzheng Exp $
 */
@ContextConfiguration("classpath:META-INF/spring/tranction.xml")
public class TransactionTest extends AbstractTransactionalTestNGSpringContextTests {
    private static final String JDBC_URL = "jdbc:h2:mem:haha";

    private static final String USER = "";
    private static final String PASSWORD = "sa";
    private static final String DRIVER_CLASS = "org.h2.Driver";

    @Autowired
    private FeatureCalImpl hehe;

    @Test
    public void test() throws Exception {
        simpleJdbcTemplate.getJdbcOperations().execute("insert into test (name) values('lwz');");
        List<String> ret = simpleJdbcTemplate.getJdbcOperations().queryForList("select name from test", String.class);
        ret.forEach(System.out::println);
    }

    @Test(dependsOnMethods = "test")
    public void test2() {
        List<String> ret = simpleJdbcTemplate.getJdbcOperations().queryForList("select name from test", String.class);
        ret.forEach(System.out::println);
    }

}