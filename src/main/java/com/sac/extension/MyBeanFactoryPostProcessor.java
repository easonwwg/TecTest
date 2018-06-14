package com.sac.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("*************start进入到自定义的BeanFactoryPostProcessor*****************");
        System.out.println("进入到自定义的BeanFactoryPostProcessor的postProcessBeanFactory方法，对BeanFactory做扩展");
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println("beanDefinition名字是------" + definitionName);
        }
        System.out.println("*************end进入到自定义的BeanFactoryPostProcessor*****************");
    }
}
