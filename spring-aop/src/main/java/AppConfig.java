
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;
import java.lang.reflect.Method;

@ComponentScan("com.yph")
@EnableAspectJAutoProxy
public class AppConfig {

//    @Bean
//    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() throws IOException {
//        BeanNameAutoProxyCreator autoProxyCreator = new BeanNameAutoProxyCreator();
//        autoProxyCreator.setBeanNames("order*");
//        autoProxyCreator.setInterceptorNames("customAroundAdvice");
//        return autoProxyCreator;
//    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() throws IOException {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("test2");

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(pointcut);
        defaultPointcutAdvisor.setAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
                System.out.println("after....");
            }
        });
        return defaultPointcutAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();

        return defaultAdvisorAutoProxyCreator;
    }
}
