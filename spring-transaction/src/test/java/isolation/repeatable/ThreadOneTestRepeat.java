package isolation.repeatable;

import com.yph.controller.StoreController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ThreadOneTestRepeat {

    ClassPathXmlApplicationContext ioc;
    StoreController storeController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeController = ioc.getBean(StoreController.class);
    }

    /**
     * 可重复读：同一线程读取多次的结果相同，即使中间有其它线程修改值
     * mysql默认隔离级别：REPEATABLE_READ (select @@transaction_isolation;查看)
     * 因此@Transactional 等同于 @Transactional(isolation = Isolation.REPEATABLE_READ)
     * 不会阻止读写
     */
    @Test
    public void test() throws InterruptedException {
        storeController.getBalanceRepeatable("印鹏海");
    }

}
