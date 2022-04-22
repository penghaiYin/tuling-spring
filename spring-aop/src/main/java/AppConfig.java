
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@ComponentScan("com.yph")
public class AppConfig {

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() throws IOException {
        BeanNameAutoProxyCreator autoProxyCreator = new BeanNameAutoProxyCreator();
        autoProxyCreator.setBeanNames("order*");
        autoProxyCreator.setInterceptorNames("customAroundAdvice");
        return autoProxyCreator;
    }
}
