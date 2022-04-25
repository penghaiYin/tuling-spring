package isolation.repeatable;

import com.yph.controller.StoreController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadTwoTestRepeat {

    ClassPathXmlApplicationContext ioc;
    StoreController storeController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeController = ioc.getBean(StoreController.class);
    }

    @Test
    public void test(){
        storeController.deduct(100,"印鹏海");
    }

}
