package org.serendipity.session.defaults;

import org.serendipity.binding.MapperRegistry;
import org.serendipity.session.SqlSession;
import org.serendipity.session.SqlSessionFactory;

import java.io.Serializable;

/**
 * @author Serendipity
 * @description
 * @date 2025-04-18 19:03
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory, Serializable {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
