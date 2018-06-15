package com.sac.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContextAware implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyApplicationContextAware.applicationContext = applicationContext;
        System.out.println("进入到自定义ApplicationContextAware");
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
