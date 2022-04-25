package propagate.mydefault;

import com.yph.controller.StoreTransactionController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropagationDefaultTest {
    ClassPathXmlApplicationContext ioc;
    StoreTransactionController storeTransactionController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeTransactionController = ioc.getBean(StoreTransactionController.class);
    }

    /**
     * REQUIRED（默认）
     * 外部不存在事务：开启新的事务
     * 外部存在事务：融合到外部事务中
     */
    @Test
    public void test(){
        storeTransactionController.transfer(200,"印鹏海","陈亿万");
    }
}
