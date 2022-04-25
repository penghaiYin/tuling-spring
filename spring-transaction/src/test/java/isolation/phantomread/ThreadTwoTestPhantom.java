package isolation.phantomread;

import com.yph.controller.StoreController;
import com.yph.pojo.Store;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadTwoTestPhantom {

    ClassPathXmlApplicationContext ioc;
    StoreController storeController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeController = ioc.getBean(StoreController.class);
    }

    @Test
    public void test(){
        Store store = new Store();
        store.setName("吴健");
        store.setBalance(1000);
        storeController.insert(store);
    }

}
