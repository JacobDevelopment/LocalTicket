package io.jacobking.localticket.database;

import io.jacobking.localticket.database.handling.SecurityHandler;

public class Database {

    private static final Database instance = new Database();

    private final ConnectionPool connectionPool;
    private final SecurityHandler securityHandler;

    private Database() {
        this.connectionPool = new ConnectionPool();
        this.securityHandler = new SecurityHandler(connectionPool);
    }

    public static Database getInstance() {
        if (instance == null)
            return new Database();
        return instance;
    }

    public SecurityHandler getSecurity() {
        return securityHandler;
    }

    public void closePool() {
        this.connectionPool.close();
    }

    public boolean isLive() {
        return connectionPool.isConnected();
    }
}
