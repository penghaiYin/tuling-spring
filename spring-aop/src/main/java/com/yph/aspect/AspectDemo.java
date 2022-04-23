package com.yph.aspect;

import com.yph.ProductInterface;
import com.yph.UserInterface;
import com.yph.service.impl.ProductImpl;
import com.yph.service.impl.UserImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

    /**
     * 增强OrderService
     * 相当于给UserService实现ProductInterface，工作中不常使用
     */
    @DeclareParents(value = "com.yph.service.OrderService", defaultImpl = ProductImpl.class)
    private ProductInterface productInterface;

}
