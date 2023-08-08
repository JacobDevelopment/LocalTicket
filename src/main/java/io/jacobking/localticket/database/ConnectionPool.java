package io.jacobking.localticket.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.jacobking.localticket.core.utility.FileCommons;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static final String BASE_URL = "jdbc:sqlite:file:%s?cipher=sqlcipher&key=%s&legacy=4";
    private final HikariConfig hikariConfig;
    private HikariDataSource dataSource;
    public ConnectionPool() {
        SQLiteDatabase.loadLibs();
        this.hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.sqlite.JDBC");
        hikariConfig.setPoolName("Connection-Pool");
        System.getProperties().setProperty("org.jooq.no-logo", "true");
        System.getProperties().setProperty("org.jooq.no-tips", "true");
    }

    public boolean connect(final String password) {
        hikariConfig.setJdbcUrl(BASE_URL.formatted(FileCommons.DATABASE_PATH, password));
        this.dataSource = new HikariDataSource(hikariConfig);

        try {
            final Connection connection = dataSource.getConnection();
            if (connection == null || connection.isClosed())
                return false;
        } catch (SQLException e) {
            return false;
        }

        return true;
    }


}
