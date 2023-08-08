package io.jacobking.localticket.database;

public class Database {

    private static final Database instance = new Database();

    private final ConnectionPool connectionPool;

    private Database() {
        this.connectionPool = new ConnectionPool();
    }

    public static Database getInstance() {
        if (instance == null)
            return new Database();
        return instance;
    }

    public void closePool() {
        this.connectionPool.close();
    }

    public boolean isLive() {
        return connectionPool.isConnected();
    }
}
