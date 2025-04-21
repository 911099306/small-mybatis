package org.serendipity.test.ApiTest;

import org.junit.Test;
import org.serendipity.binding.MapperProxyFactory;
import org.serendipity.binding.MapperRegistry;
import org.serendipity.io.Resources;
import org.serendipity.session.SqlSession;
import org.serendipity.session.SqlSessionFactory;
import org.serendipity.session.SqlSessionFactoryBuilder;
import org.serendipity.session.defaults.DefaultSqlSession;
import org.serendipity.test.ApiTest.dao.IUserDao;
import org.serendipity.test.ApiTest.po.User;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Serendipity
 * @description 测试映射器代理工程
 * @date 2025-04-18 14:49
 **/
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_MapperProxyFactory() {
        // MapperProxyFactory<IUserDao> proxyFactory = new MapperProxyFactory<>(IUserDao.class);
        //
        // Map<String, String> sqlSession = new HashMap<>();
        // sqlSession.put("org.serendipity.test.ApiTest.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        // sqlSession.put("org.serendipity.test.ApiTest.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        // IUserDao userDao = proxyFactory.newInstance(sqlSession);
        //
        // String info = userDao.queryUserName("10001");
        // logger.info("测试结果：{}", info);
    }

    @Test
    public void test_DefaultSqlSessionFactory() {

        // // 1. 注册 MapperProxy
        // MapperRegistry mapperRegistry = new MapperRegistry();
        // mapperRegistry.addMappers("org.serendipity.test.ApiTest.dao");
        //
        // // 2. 创建sqlSession
        // DefaultSqlSession sqlSession = new DefaultSqlSession(mapperRegistry);
        // IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //
        // // 3. 使用代理类进行查询
        // String string = userDao.queryUserName("1");
        // System.out.println("string = " + string);
    }

    @Test
    public void test_SqlSessionFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        String user = userDao.queryUserInfoById("1");
        System.out.println("user = " + user);


    }
}
