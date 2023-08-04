package io.jacobking.localticket.database;

import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;
import io.jacobking.localticket.database.query.Query;

import java.io.IOException;

public class Database {

    private static final Database instance = new Database();
    private final ConnectionPool connectionPool;
    private Database() {
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
            writeDatabaseScheme();
        }
    }

    private void writeDatabaseScheme() {
        final boolean test = Query.build("CREATE TABLE TESTING(lol TEXT);").execute();
        if (test) {
            System.out.println("executed");
        } else {
            System.out.println("Failed");
        }
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
