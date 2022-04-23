import com.yph.ProductInterface;
import com.yph.UserInterface;
import com.yph.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
//        orderService.test();
        ProductInterface orderService = (ProductInterface) applicationContext.getBean("orderService");
        orderService.product();
    }
}
