package org.serendipity.transaction;

import org.serendipity.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Serendipity
 * @description 事务工厂
 * @date 2025-04-23 20:06
 **/
public interface TransactionFactory {

    /**
     * 根据 Connection 创建 Transaction 对象
     * @param conn 存在的database 连接
     * @return 事务对象
     */
    Transaction newTransaction(Connection conn);

    /**
     * 根据数据源和事务隔离级别创建事务对象 Transaction
     * @param dataSource 数据源信息
     * @param level 事务隔离界别
     * @param autoCommit 是否紫铜提交
     * @return 事务对象
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);
}
