package com.sac.quartz;

import org.springframework.stereotype.Component;

/**
 * @author:eason
 * @Description
 * @Date: 22:34,2018/1/16
 * @ModifiedBy
 */

@Component("anotherBean")
public class AnotherBean {
    public void printAnotherMessage() {
        System.out.println("AnotherMessage");
    }
}
