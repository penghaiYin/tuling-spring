1.spring 整合 mybatis 为什么使用 sqlSessionTemplate ？
    答：解决线程不安全的问题。如何保证? 使用ThreadLocal 每个线程创建一个sqlSession

2.为什么开启spring事务，mybatis一级缓存才会生效?
    答：因为sqlSession绑定ThreadLocal是基于spring事务做的。 为什么？
    答：因为不开启事务，每个sql本身执行就是独立的，就会创建新的sqlSession，故也会导致缓存失效。
不建议使用mybatis的一级缓存，因为会和数据库的隔离级别冲突。优先考虑隔离级别

3.如果不开启spring事务又想用mybatis一级缓存？
    答：@Bean构建sqlSession，使用@Autowired 注入，保证线程执行的sqlSession是同一个即可

4.spring-mybatis 整合2.0和1.0的区别
    答：2.0支持直接添加MapperScannerConfigurer 扫描mapper注册bean，可以不使用@MapperScan