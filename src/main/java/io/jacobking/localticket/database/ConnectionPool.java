package io.jacobking.localticket.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.SQLExceptionOverride;
import io.jacobking.localticket.core.config.Config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;


public class ConnectionPool {

    private static final long KEEP_ALIVE_IN_MS = Duration.ofMinutes(2).toMillis();
    private static final long TIMEOUT_IN_MS = Duration.ofMinutes(10).toMillis();
    private static final Config config = Config.getInstance();
    private final HikariConfig hikariConfig;

    private Connection connection;
    private HikariDataSource hikariDataSource;

    public ConnectionPool() {
        this.hikariConfig = new HikariConfig();
        this.connection = null;
        constructConfig();
    }

    private void constructConfig() {
        final String URL = config.getDatabaseUrl();
        if (URL.isEmpty())
            return;

        this.hikariConfig.setDriverClassName("org.sqlite.JDBC");
        this.hikariConfig.setJdbcUrl(URL);
        this.hikariConfig.setPoolName("Database");
        this.hikariConfig.setKeepaliveTime(KEEP_ALIVE_IN_MS);
        this.hikariConfig.setConnectionTimeout(TIMEOUT_IN_MS);
        this.hikariDataSource = new HikariDataSource(hikariConfig);
    }


    public Connection getConnection() {
        try {
            if (this.connection == null) {
                this.connection = hikariDataSource.getConnection();
                return connection;
            }
        } catch (SQLException e) {
            return getConnection();
        }
        return connection;
    }
}
