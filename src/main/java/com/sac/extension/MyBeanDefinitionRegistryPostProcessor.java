package com.sac.extension;


import com.sac.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("加入到自定义的BeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法，对BeanDefinition做扩展");
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class).getBeanDefinition();
        beanDefinition.setLazyInit(true);
        beanDefinition.setScope("singleton");
        registry.registerBeanDefinition("p3", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("加入到自定义的BeanDefinitionRegistryPostProcessor的postProcessBeanFactory方法，对beanFactory做扩展，等同于等同于MyBeanFactoryPostProcessor中的postProcessBeanFactory方法");
    }
}
