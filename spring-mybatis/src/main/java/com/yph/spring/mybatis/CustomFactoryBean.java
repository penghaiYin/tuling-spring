package com.yph.spring.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;

public class CustomFactoryBean implements FactoryBean {
    private Class mapperInterface;

    private SqlSession sqlSession;

    public CustomFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

//    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperInterface);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {
//        Object proxyInstance = Proxy.newProxyInstance(CustomFactoryBean.class.getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(method.getName());
//                return null;
//            }
//        });
//        return proxyInstance;
        return sqlSession.getMapper(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
