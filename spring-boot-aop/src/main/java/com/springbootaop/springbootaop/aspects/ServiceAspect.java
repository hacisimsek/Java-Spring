package com.springbootaop.springbootaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.springbootaop.springbootaop.service.*.*(..))")
    public void beforeGiveMessage(JoinPoint joinPoint){
        System.out.println("Before giveMessage function it cached param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.springbootaop.springbootaop.service.*.*(..))")
    public void afterGiveMessage(JoinPoint joinPoint){
        System.out.println("After giveMessage function it cached param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
