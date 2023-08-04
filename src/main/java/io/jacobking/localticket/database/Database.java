package io.jacobking.localticket.database;

import io.jacobking.localticket.LocalTicket;
import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;
import io.jacobking.localticket.database.query.Query;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            copyDefaultDatabase();
        }
    }

    private void copyDefaultDatabase() {
        try (final InputStream inputStream = LocalTicket.class.getResourceAsStream("default.sqlite")) {
            if (inputStream == null)
                return;
            final File file = new File(FileCommons.DATABASE_FILE);
            FileUtils.copyInputStreamToFile(inputStream, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
