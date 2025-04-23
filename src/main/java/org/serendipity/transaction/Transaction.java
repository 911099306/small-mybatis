package org.serendipity.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Serendipity
 * @description 事务接口
 * @date 2025-04-23 20:06
 **/
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
