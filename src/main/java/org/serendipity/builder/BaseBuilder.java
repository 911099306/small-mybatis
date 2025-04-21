package org.serendipity.builder;

import org.serendipity.session.Configuration;

/**
 * @author Serendipity
 * @description 构建器的基类，建造者模式
 * @date 2025-04-21 20:40
 **/
public abstract class BaseBuilder {

    protected final Configuration configuration;

    protected BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
