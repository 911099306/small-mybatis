package org.serendipity.builder;

import org.serendipity.session.Configuration;
import org.serendipity.type.TypeAliasRegistry;

/**
 * @author Serendipity
 * @description 构建器的基类，建造者模式
 * @date 2025-04-21 20:40
 **/
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    protected BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
