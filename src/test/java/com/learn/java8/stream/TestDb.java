/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.learn.java8.stream;


import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lifangzheng
 * @version $Id: TestDb.java, v 0.1 2019年09月02日 18:02 lifangzheng Exp $
 */
public class TestDb {
    @Test
    public void test() throws Exception {
        //Class.forName("org.hsqldb.jdbcDriver");

        Connection connection = DriverManager.getConnection("jdbc:hsqldb:res:foodmart");
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement.executeQuery("select \"employee_id\", \"full_name\" from \"foodmart\".\"employee\" ");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + ":" + resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }


}