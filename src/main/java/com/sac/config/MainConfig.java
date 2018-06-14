package com.sac.config;

import com.sac.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional({WindowsCondition.class})
@Configuration
public class MainConfig {

    @Bean(name = "p1")
    public Person person() {
        Person person = new Person();
        person.setAge(22);
        return person;
    }

    @Bean(name = "p2")
    public Person person1() {
        Person person = new Person();
        person.setAge(24);
        return person;
    }
}
