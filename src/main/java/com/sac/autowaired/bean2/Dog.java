package com.sac.autowaired.bean2;

import com.sac.autowaired.IAnimal;
import org.springframework.stereotype.Component;

/**
 * @author:eason
 * @Description： @Component 代表这个类为组件，会被扫描
 * @Date: 13:54,2018/1/17
 * @ModifiedBy
 */

@Component("dogComponent")
public class Dog  implements IAnimal {

    @Override
    public void say() {
        System.out.println("I am Dog");
    }
}
