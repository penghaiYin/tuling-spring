package propagate.requirenew;

import com.yph.controller.StoreTransactionController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropagationRequireNewTest {
    ClassPathXmlApplicationContext ioc;
    StoreTransactionController storeTransactionController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeTransactionController = ioc.getBean(StoreTransactionController.class);
    }

    /**
     * REQUIRES_NEW
     * 事务传播涉及到挂起事务时，在同一个类中不会生效
     * 外部不存在事务：开启新的事务
     * 外部存在事务：挂起外部事务，创建新的事务
     *
     */
    @Test
    public void test() {
        storeTransactionController.transferRequireNew(200,"印鹏海","陈亿万");
    }

}
