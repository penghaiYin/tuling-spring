package isolation.dirtyread;

import com.yph.controller.StoreController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadTwoTestDirty {

    ClassPathXmlApplicationContext ioc;
    StoreController storeController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeController = ioc.getBean(StoreController.class);
    }

    /**
     * 脏读：两个线程同时进行，第一个线程对数据进行修改未提交事务，第二个线程读取到的是第一个线程已修改的数据
     * 数据库层面已经解决这个问题，只会读取事务提交的数据
     */
    @Test
    public void test() throws InterruptedException {
        storeController.delayDeduct(100,"印鹏海");
    }

}
