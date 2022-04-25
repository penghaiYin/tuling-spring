package isolation.dirtyread;

import com.yph.controller.StoreController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadOneTestDirty {

    ClassPathXmlApplicationContext ioc;
    StoreController storeController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeController = ioc.getBean(StoreController.class);
    }

    /**
     * 脏读：两个线程同时进行，第一个线程对数据进行修改未提交事务，第二个线程读取到的是第一个线程已修改的数据
     * 不管有没有加事务，都读的已提交的数据
     */
    @Test
    public void test(){
        storeController.getBalance("印鹏海");
    }

}
