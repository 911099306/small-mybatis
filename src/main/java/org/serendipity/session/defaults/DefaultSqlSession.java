package org.serendipity.session.defaults;

import org.serendipity.binding.MapperRegistry;
import org.serendipity.mapping.MappedStatement;
import org.serendipity.session.Configuration;
import org.serendipity.session.SqlSession;

import java.io.Serializable;

/**
 * @author Serendipity
 * @description
 * @date 2025-04-18 19:02
 **/
public class DefaultSqlSession implements SqlSession, Serializable {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

}
