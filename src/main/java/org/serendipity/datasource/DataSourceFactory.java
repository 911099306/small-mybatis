package org.serendipity.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Serendipity
 * @description 数据源工厂
 * @date 2025-04-23 20:01
 **/
public interface DataSourceFactory {

    void setProperties(Properties properties);

    DataSource getDataSource();
}
