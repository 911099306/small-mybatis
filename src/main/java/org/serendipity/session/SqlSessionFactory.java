package org.serendipity.session;

/**
 * @author Serendipity
 * @description 工厂模式接口 sqlSession工厂
 * @date 2025-04-18 19:01
 **/
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
