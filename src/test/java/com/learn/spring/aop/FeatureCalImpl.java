/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.learn.spring.aop;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author lifangzheng
 * @version $Id: RefClass.java, v 0.1 2019年09月25日 21:13 lifangzheng Exp $
 */
@Slf4j
public class FeatureCalImpl {
    private String str;

    public void cal0(String input) {
        log.info("execute " + input + " !");
    }

    public String getStr() {
        return str;
    }

    @Required
    public FeatureCalImpl setStr(String str) {
        this.str = str;
        return this;
    }
}