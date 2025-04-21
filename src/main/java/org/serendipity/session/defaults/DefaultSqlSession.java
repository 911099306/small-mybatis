package org.serendipity.session.defaults;

import org.serendipity.binding.MapperRegistry;
import org.serendipity.session.SqlSession;

import java.io.Serializable;

/**
 * @author Serendipity
 * @description
 * @date 2025-04-18 19:02
 **/
public class DefaultSqlSession implements SqlSession, Serializable {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }

}
