import com.yph.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcTemplateTest {

    ApplicationContext applicationContext;

    @Before
    public void before(){
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void test(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        DataSource dataSource = jdbcTemplate.getDataSource();
        System.out.println(dataSource);
    }

    @Test
    public void test2(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        User user = jdbcTemplate.queryForObject("select * from user where id=?", new BeanPropertyRowMapper<>(User.class),1);
        System.out.println(user.toString());
    }

    /**
     * 使用具备具名函数的jdbcTemplate
     */
    @Test
    public void test3(){
        NamedParameterJdbcTemplate jdbcTemplate = (NamedParameterJdbcTemplate) applicationContext.getBean("namedParameterJdbcTemplate");
        Map<String,Object> map = new HashMap<>();
        map.put("id",2);
        User user = jdbcTemplate.queryForObject("select * from user where id=:id", map,new BeanPropertyRowMapper<>(User.class));
        System.out.println(user);
    }
}
