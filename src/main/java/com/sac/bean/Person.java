package com.sac.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements InitializingBean, DisposableBean {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "xxxxxxxxxx" + age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet这个方法在postProcessBeforeInitialization之后执行，在postProcessAfterInitialization之前执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("person销毁");
    }
}
