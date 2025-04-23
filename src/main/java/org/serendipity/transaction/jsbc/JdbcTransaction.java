package org.serendipity.transaction.jsbc;

import org.serendipity.session.TransactionIsolationLevel;
import org.serendipity.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Serendipity
 * @description JDBC 事务，直接利用 JDBC的 commit、commit。依赖于数据源获得的连接来管理事务范围。
 * @date 2025-04-23 20:06
 **/
public class JdbcTransaction implements Transaction {

    protected Connection connection;
    protected DataSource dataSource;
    protected boolean autoCommit;
    protected TransactionIsolationLevel level = TransactionIsolationLevel.NONE;

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }
    public JdbcTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        this.dataSource = dataSource;
        this.level = level;
        this.autoCommit = autoCommit;
    }



    @Override
    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setTransactionIsolation(level.getLevel());
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    @Override
    public void commit() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.commit();
        }
    }

    @Override
    public void rollback() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.rollback();
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.close();
        }
    }
}
