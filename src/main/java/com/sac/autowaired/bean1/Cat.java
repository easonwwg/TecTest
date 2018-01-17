package com.sac.autowaired.bean1;

import com.sac.autowaired.IAnimal;
import org.springframework.stereotype.Component;

/**
 * @author:eason
 * @Description：
 * @Date: 14:06,2018/1/17
 * @ModifiedBy
 */
@Component("catComponent")
public class Cat implements IAnimal {
    @Override
    public void say() {
        System.out.println("I am Cat");
    }
}
