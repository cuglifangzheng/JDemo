/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.learn.spring.aop;

import com.alipay.common.tracer.context.AbstractLogContext;
import com.alipay.common.tracer.context.SofaRestLogContext;
import com.alipay.common.tracer.util.TracerContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 *
 * @author lifangzheng
 * @version $Id: TransactionTest.java, v 0.1 2019年09月25日 19:34 lifangzheng Exp $
 */
@ContextConfiguration("classpath:META-INF/spring/aop.xml")
public class AopTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FeatureCalImpl featureCal;

    @Test
    public void testhehe() {
        SofaRestLogContext context = new SofaRestLogContext();
        context.setTraceId("1badfc");
        AbstractLogContext.set(context);
        featureCal.cal0("计算特征1");
    }
}