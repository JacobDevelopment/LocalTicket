package io.jacobking.localticket.database;

import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;

import java.io.IOException;

public class Database {

    private static final Database instance = new Database();

    private boolean isConnected;
    private final ConnectionPool connectionPool;
    private Database() {
        this.isConnected = false;
        this.connectionPool = new ConnectionPool();
        init();
    }
    public static Database getInstance() {
        if (instance == null)
            return new Database();
        return instance;
    }

    private void init() {
        checkIfDatabaseFileExists();
    }

    private void checkIfDatabaseFileExists() {
        if (!FileIO.doesDirectoryExist(FileCommons.DATABASE_DIRECTORY)) {
            FileIO.createDirectory(FileCommons.DATABASE_DIRECTORY);
        }

        if (!FileIO.doesFileExist(FileCommons.DATABASE_FILE)) {
            try {
                FileIO.createFile(FileCommons.DATABASE_FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            connectionPool.connect();
            writeDatabaseScheme();
            return;
        }

        connectionPool.connect();
    }

    private void writeDatabaseScheme() {

    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected() {
        this.isConnected = true;
    }

    public static boolean isInitialized() {
        return instance.isConnected();
    }

}
