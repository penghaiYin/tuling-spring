package com.yph.proxy;

import com.yph.UserInterface;
import com.yph.service.impl.UserImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
// cglib动态代理
//        UserService target = new UserService();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserService.class);
//        enhancer.setCallbacks(new Callback[]{
//                new MethodInterceptor() {
//                    @Override
//                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                        System.out.println("before...");
//                        Object result = methodProxy.invoke(target, objects);
////                        下面2种方式也可以实现
////                        Object invoke = method.invoke(target, objects);//通过反射执行被代理对象的方法
////                        methodProxy.invokeSuper(o, objects);// 执行代理对象的父类的方法: userServiceProxy extends UserService
//                        System.out.println("after...");
//                        return result;
//                    }
//                }, NoOp.INSTANCE
//        });
//
//        enhancer.setCallbackFilter(new CallbackFilter() {
//            @Override
//            public int accept(Method method) {
//                if(method.getName().equals("test"))
//                return 0; else return 1;
//            }
//        });
//
//        UserService userService = (UserService) enhancer.create();
//        userService.test();
//        userService.test2();

        // JDK动态代理
        UserImpl target = new UserImpl();
        UserInterface userInterface = (UserInterface) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{UserInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before...");
                Object result = method.invoke(target, args);
                System.out.println("after...");
                return result;
            }
        });
        userInterface.test();
    }
}
