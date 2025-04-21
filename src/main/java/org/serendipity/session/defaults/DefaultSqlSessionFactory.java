package org.serendipity.session.defaults;

import org.serendipity.binding.MapperRegistry;
import org.serendipity.session.Configuration;
import org.serendipity.session.SqlSession;
import org.serendipity.session.SqlSessionFactory;

import java.io.Serializable;

/**
 * @author Serendipity
 * @description
 * @date 2025-04-18 19:03
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory, Serializable {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
