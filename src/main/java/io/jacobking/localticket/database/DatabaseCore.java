package io.jacobking.localticket.database;

import io.jacobking.localticket.LocalTicket;
import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DatabaseCore {

    private static final String DEFAULT_PATH = "sql/core.sqlite";

    private boolean initialized = false;

    public DatabaseCore() {
        initialize();
    }

    private void initialize() {
        if (!FileIO.doesDirectoryExist(FileCommons.DATABASE_DIRECTORY)) {
            System.out.println("Creating DATABASE_DIRECTORY");
            FileIO.createDirectory(FileCommons.DATABASE_DIRECTORY);
        }

        if (!FileIO.doesFileExist(FileCommons.DATABASE_PATH)) {
            System.out.println("Creating DATABASE FILE");
            createDatabaseFile();
        }

        this.initialized = true;
    }

    private void createDatabaseFile() {
        final InputStream defaultDatabase = getDefaultDatabaseStream();
        if (defaultDatabase == null) {
            System.out.println("Could not find default database to copy.");
            this.initialized = false;
            return;
        }

        try {
            FileIO.createFile(FileCommons.DATABASE_PATH);
            final File file = new File(FileCommons.DATABASE_PATH);
            FileUtils.copyInputStreamToFile(defaultDatabase, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getDefaultDatabaseStream() {
        return LocalTicket.class.getResourceAsStream(DEFAULT_PATH);
    }

    public boolean isInitialized() {
        return initialized;
    }
}
