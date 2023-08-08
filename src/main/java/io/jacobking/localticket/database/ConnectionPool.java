package io.jacobking.localticket.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.jacobking.localticket.core.utility.FileCommons;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionPool {

    private static final String BASE_URL = "jdbc:sqlite:file:%s";
    private final HikariConfig hikariConfig;
    private HikariDataSource dataSource;

    private Connection connection = null;
    public ConnectionPool() {
        this.hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.sqlite.JDBC");
        hikariConfig.setJdbcUrl(BASE_URL.formatted(FileCommons.DATABASE_PATH));
        hikariConfig.setPoolName("Connection-Pool");
        System.getProperties().setProperty("org.jooq.no-logo", "true");
        System.getProperties().setProperty("org.jooq.no-tips", "true");
        this.dataSource = new HikariDataSource(hikariConfig);
    }

    public void close() {
        if (dataSource.isRunning()) {
            dataSource.close();
            this.dataSource = null;
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
            return getConnection();
        }
        return connection;
    }


}
