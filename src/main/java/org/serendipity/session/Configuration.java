package org.serendipity.session;

import org.serendipity.binding.MapperRegistry;
import org.serendipity.datasource.druid.DruidDataSourceFactory;
import org.serendipity.mapping.Environment;
import org.serendipity.mapping.MappedStatement;
import org.serendipity.transaction.jsbc.JdbcTransactionFactory;
import org.serendipity.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Serendipity
 * @description 核心配置类，存储mybatis的所有配置信息
 * @date 2025-04-21 19:36
 **/
public class Configuration {

    /**
     * 环境信息
     */
    protected Environment environment;

    /**
     * 映射注册器
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map内
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    /**
     * 类型别名注册机
     */
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }
}
