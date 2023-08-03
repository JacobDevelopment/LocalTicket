package io.jacobking.localticket.core.config;

import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    public boolean initialized() throws IOException {
        if (!doesMainDirectoryExist()) {
            return false;
        }

        if (doesConfigFileExist()) {
            writeDefaultProperties(new File(FileCommons.CONFIG_DIRECTORY));
            return true;
        }

        return false;
    }

    private boolean doesMainDirectoryExist() {
        if (!FileIO.doesDirectoryExist(FileCommons.MAIN_DIRECTORY)) {
            return FileIO.createDirectory(FileCommons.MAIN_DIRECTORY);
        }
        return true;
    }

    private boolean doesConfigFileExist() {
        try {
            if (!FileIO.doesFileExist(FileCommons.CONFIG_DIRECTORY)) {
                final File file = FileIO.createFile(FileCommons.CONFIG_DIRECTORY);
                return file.exists();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private void writeDefaultProperties(final File file) throws IOException {
        final Properties properties = new Properties();
        properties.load(new FileReader(FileCommons.CONFIG_DIRECTORY));
        properties.setProperty("database_url", "test");
        properties.setProperty("database_username", "");
        properties.setProperty("database_password", "");
        properties.setProperty("profile_url", "");
        properties.store(new FileWriter(file), null);
    }
}
