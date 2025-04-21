package org.serendipity.session;

/**
 * @author Serendipity
 * @description mybatis核心类，用于执行SQL，获取映射器，管理事务等
 * @date 2025-04-18 19:01
 **/
public interface SqlSession {


    /**
     * 根据指定的 SqlID：namespace.id 获取一条封装记录的封装对象
     *
     * @param statement statement sqlID
     * @return  封装之后的查询结果
     * @param <T> 封装之后的对象类型
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的 SqlID：namespace.id 获取一条封装记录的封装对象，并且允许传递一些参数信息
     * 使用中，一般传入一个pojo对象，或者 Map 对象
     *
     * @param statement 唯一标识
     * @param parameter 参属信息
     * @return 封装之后的查询结果
     * @param <T> 封装之后的对象类型
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 获得mybatis的Configuration
     * @return configuration
     */
    Configuration getConfiguration();

    /**
     * 代理模式，得到映射器。使用泛型，返回所需要的类型直接
     *
     * @param type Mapper Interface class 的类型
     * @return a mapper bound to this SqlSession
     * @param <T> mapper 的类型
     */
    <T> T getMapper(Class<T> type);
}
