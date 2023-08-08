package io.jacobking.localticket.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.jacobking.localticket.core.utility.FileCommons;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionPool {

    private static final String BASE_URL = "jdbc:sqlite:file:%s";
    private final HikariConfig hikariConfig;
    private HikariDataSource dataSource;

    private DSLContext dsl;
    private Connection connection = null;
    public ConnectionPool() {
        this.hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.sqlite.JDBC");
        hikariConfig.setJdbcUrl(BASE_URL.formatted(FileCommons.DATABASE_PATH));
        hikariConfig.setPoolName("Connection-Pool");
        System.getProperties().setProperty("org.jooq.no-logo", "true");
        System.getProperties().setProperty("org.jooq.no-tips", "true");
        this.dataSource = new HikariDataSource(hikariConfig);
        this.dsl = DSL.using(dataSource, SQLDialect.SQLITE);
    }

    public void close() {
        if (dataSource.isRunning()) {
            dataSource.close();
            this.dataSource = null;
            this.dsl = null;
        }
    }

    public boolean isConnected() {
        try {
            final Connection connection = dataSource.getConnection();
            if (connection == null || connection.isClosed())
                return false;

            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            isConnected();
            this.dsl = DSL.using(dataSource, SQLDialect.SQLITE);
            return getConnection();
        }
        return connection;
    }

    public DSLContext getDSL() {
        return dsl;
    }

}
