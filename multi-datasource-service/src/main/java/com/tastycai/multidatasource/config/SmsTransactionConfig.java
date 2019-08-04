package com.tastycai.multidatasource.config;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

public class SmsTransactionConfig {

    // 事物管理器
    @Bean("smsTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("smsDatasource") DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);

    }

    // 通知
    @Bean("smsTxAdvice")
    public TransactionInterceptor transactionInterceptor(@Qualifier("smsTransactionManager") DataSourceTransactionManager transactionManager){

        NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();

        List<RollbackRuleAttribute> rollbackRuleAttributeList = Collections.singletonList(new RollbackRuleAttribute(Throwable.class));

        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setTimeout(30);
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setRollbackRules(rollbackRuleAttributeList);

        transactionAttributeSource.addTransactionalMethod("insert",requiredTx);

        RuleBasedTransactionAttribute supportTx = new RuleBasedTransactionAttribute();
        requiredTx.setTimeout(30);
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
        requiredTx.setRollbackRules(rollbackRuleAttributeList);

        transactionAttributeSource.addTransactionalMethod("*",supportTx);

        return new TransactionInterceptor(transactionManager,transactionAttributeSource);
    }

    // 切面
    @Bean
    public Advisor advisor(@Qualifier("smsTxAdvice") Advice advice){

        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();

        aspectJExpressionPointcut.setExpression("execution(* com.tastycai.multidatasource.sms.service..*(..))");

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(aspectJExpressionPointcut,advice);
        defaultPointcutAdvisor.setOrder(5);

        return defaultPointcutAdvisor;

    }
}
