package org.serendipity.binding;

import org.serendipity.session.SqlSession;
import cn.hutool.core.lang.ClassScanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Serendipity
 * @description 映射器注册机
 * @date 2025-04-18 19:10
 **/
public class MapperRegistry {

    /**
     * 将一天假的映射器代理加入到 HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    /**
     * 获取 Mapper
     * @param type IDao的接口类型
     * @param sqlSession 核心处理对象SqlSession
     * @return IDao的相应实现类
     */
    public <T> T getMapper(Class<?> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);

        if (mapperProxyFactory == null) {
            throw new RuntimeException("org.serendipity.binding.MapperRegistry: Type: " + type + " is not known to the MapperRegistry...");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("org.serendipity.binding.MapperRegistry: Error getting mapper instance. Cause: " + e, e);
        }
    }

    /**
     * 扫描 指定包下的所有名称，并依次为其创建实现类
     * @param packageName 包名
     */
    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }

    /**
     * 注册接口
     * @param type 接口类型
     */
    public <T> void addMapper(Class<T> type) {
        // type 必须是一个接口才可以
        if (type.isInterface()) {
            if (hasMapper(type)) {
                throw new RuntimeException("org.serendipity.binding.MapperRegistry: Type " + type + " is already known to the MapperRegistry...");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    /**
     * 判断 Map 内是否已经生成该接口的实现类
     * @param type 接口类型
     * @return 是否已经生成
     */
    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }



}
