package com.sac.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author:eason
 * @Description
 * @Date: 20:22,2018/4/24
 * @ModifiedBy
 */
@Component
@Aspect
public class Advices {

    // 切点
    @Pointcut("execution(* com.sac.aop.aopservice.IMyMath.a*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        System.out.println("----------before----------");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("環繞前");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("環繞后");
        return object;
    }
}
