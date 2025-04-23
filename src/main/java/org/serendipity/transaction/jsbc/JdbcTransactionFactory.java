package org.serendipity.transaction.jsbc;

import org.serendipity.session.TransactionIsolationLevel;
import org.serendipity.transaction.Transaction;
import org.serendipity.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Serendipity
 * @description JDBC Transaction 工厂
 * @date 2025-04-23 20:06
 **/
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
