package org.serendipity.mapping;

import org.serendipity.session.Configuration;
import org.serendipity.type.JdbcType;

/**
 * @author Serendipity
 * @description 参数映射工具  #{property,javaType=int,jdbcType=NUMERIC}
 * @date 2025-04-23 20:04
 **/
public class ParameterMapping {

    private Configuration configuration;

    /**
     * property
     */
    private String property;
    /**
     * javaType = int
      */
    private Class<?> javaType = Object.class;
    /**
     * jdbcType=NUMERIC
      */
    private JdbcType jdbcType;

    private ParameterMapping() {
    }

    public static class Builder {

        private ParameterMapping parameterMapping = new ParameterMapping();

        public Builder(Configuration configuration, String property) {
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
        }

        public Builder javaType(Class<?> javaType) {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder jdbcType(JdbcType jdbcType) {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getProperty() {
        return property;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }
}
