package iocTest;

import com.sac.bean.Person;
import com.sac.extension.ExtensionConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    AnnotationConfigApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ExtensionConfig.class);
    }

    @Test
    public void conditionTest() {
        //获取容器中的bean
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void beanFactoryPostProcessir() {
    /*    Person factoryBean = (Person) applicationContext.getBean("factoryBean");
        System.out.println(factoryBean.getAge());*/
        Person p1 = (Person) applicationContext.getBean("p1");
        //System.out.println(p1.getAge());

        // applicationContext.getBean("p3");
    }

}
