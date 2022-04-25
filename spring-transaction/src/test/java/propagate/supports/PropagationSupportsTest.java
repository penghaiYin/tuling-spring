package propagate.supports;

import com.yph.controller.StoreTransactionController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropagationSupportsTest {
    ClassPathXmlApplicationContext ioc;
    StoreTransactionController storeTransactionController;

    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring.xml");
        storeTransactionController = ioc.getBean(StoreTransactionController.class);
    }

    /**
     * SUPPORTS
     * 外部不存在事务：不开启新的事务
     * 外部存在事务：融合到外部事务中
     */
    @Test
    public void test() {
        storeTransactionController.transferSupports(200,"印鹏海","陈亿万");
    }

    @Test
    public void test2() {
        storeTransactionController.transferSupportsWithLog(200,"印鹏海","陈亿万");
    }
}
