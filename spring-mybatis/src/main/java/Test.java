import com.yph.AppConfig;
import com.yph.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);

//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(CustomFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//        context.registerBeanDefinition("userMapper", beanDefinition);
//
//        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition1.setBeanClass(CustomFactoryBean.class);
//        beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
//        context.registerBeanDefinition("orderMapper", beanDefinition1);

        context.refresh();
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }
}
