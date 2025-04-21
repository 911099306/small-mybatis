package org.serendipity.session;

import org.serendipity.builder.xml.XMLConfigBuilder;
import org.serendipity.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author Serendipity
 * @description 整个Mybatis的入口
 * @date 2025-04-21 19:50
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
