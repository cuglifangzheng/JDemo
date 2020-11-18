/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.learn.java8.stream;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lifangzheng
 * @version $Id: TestH2.java, v 0.1 2019年09月25日 12:07 lifangzheng Exp $
 */
@ContextConfiguration("classpath:META-INF/spring/database_test.xml")
public class TestH2 extends AbstractTestNGSpringContextTests {
    private static final String JDBC_URL = "jdbc:h2:mem:haha";

    private static final String USER = "";
    private static final String PASSWORD = "sa";
    private static final String DRIVER_CLASS = "org.h2.Driver";

    @Test
    public void test() throws Exception {
        Class.forName(DRIVER_CLASS);

        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        statement.execute("DROP TABLE IF EXISTS USER_INF");
        statement.execute("CREATE TABLE USER_INF(id INTEGER PRIMARY KEY ,name VARCHAR(100), sex VARCHAR(2))");

        statement.executeUpdate("INSERT INTO USER_INF VALUES(1, 'tom', '男') ");
        statement.executeUpdate("INSERT INTO USER_INF VALUES(2, 'jack', '女') ");
        statement.executeUpdate("INSERT INTO USER_INF VALUES(3, 'marry', '男') ");
        statement.executeUpdate("INSERT INTO USER_INF VALUES(4, 'lucy', '男') ");

        ResultSet resultSet = statement.executeQuery("select * from USER_INF");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("name") +
                    ", " + resultSet.getString("sex"));
        }

        statement.close();
        conn.close();
    }

}