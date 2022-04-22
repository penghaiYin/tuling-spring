package com.yph.test;

import com.yph.service.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SpringProxyTest {
    public static void main(String[] args) {
        UserService target = new UserService();
        // Spring整合的动态代理
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
       /* proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("方法执行前...");
            }
        });
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("around前....");
                Object proceed = methodInvocation.proceed();
                System.out.println("around后....");
                return proceed;
            }
        });*/
        proxyFactory.addAdvisor(new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                return new StaticMethodMatcherPointcut() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return method.getName().equals("test");
                    }
                };
            }

            @Override
            public Advice getAdvice() {
                return new MethodBeforeAdvice() {
                    @Override
                    public void before(Method method, Object[] objects, Object o) throws Throwable {
                        System.out.println("before...");
                    }
                };
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        });
        // advice 责任链 + 递归 调用
//        proxyFactory.getProxy();// 底层会判断生成Cglib或者JDK代理
        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.test2();
    }

}
