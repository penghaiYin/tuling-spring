package isolation.phantomread;

import com.yph.controller.StoreController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadOneTestPhantom {

    ClassPathXmlApplicationContext ioc;
    StoreController storeController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeController = ioc.getBean(StoreController.class);
    }

    /**
     * 幻影读
     * 同一线程下多次读取的结果相同，并且阻止其它线程对表的任何修改操作
     * 会锁表
     */
    @Test
    public void test() throws InterruptedException {
        storeController.countRecord("store");
    }

}
