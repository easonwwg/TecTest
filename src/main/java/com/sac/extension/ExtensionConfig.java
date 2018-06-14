package com.sac.extension;

import com.sac.bean.Person;
import com.sac.bean.PersonFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScans(value = {
        @ComponentScan(value = "com.sac.extension", excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {RequestMapping.class})
        })
})
public class ExtensionConfig {

    @Bean(name = "p1")
    @Scope(value = "prototype")
    public Person person() {
        Person person = new Person();
        person.setAge(22);
        return person;
    }

    @Bean(name = "p2")
    @Scope(value = "prototype")
    @Lazy
    public Person person1() {
        Person person = new Person();
        person.setAge(24);
        return person;
    }

    @Bean(name = "factoryBean")
    public PersonFactoryBean personFactoryBean() {
        return new PersonFactoryBean();
    }
}
