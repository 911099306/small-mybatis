package org.serendipity.test.ApiTest;

import org.junit.Test;
import org.serendipity.binding.MapperProxyFactory;
import org.serendipity.test.ApiTest.dao.IUserDao;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;


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
        MapperProxyFactory<IUserDao> proxyFactory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("org.serendipity.test.ApiTest.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("org.serendipity.test.ApiTest.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = proxyFactory.newInstance(sqlSession);

        String info = userDao.queryUserName("10001");
        logger.info("测试结果：{}", info);

    }
}
