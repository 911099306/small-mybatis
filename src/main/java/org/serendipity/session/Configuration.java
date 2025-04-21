package org.serendipity.session;

import org.serendipity.binding.MapperRegistry;
import org.serendipity.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Serendipity
 * @description 核心配置类，存储mybatis的所有配置信息
 * @date 2025-04-21 19:36
 **/
public class Configuration {

    /**
     * 映射注册器
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map内
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();


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

}
