package io.jacobking.localticket.core.config;

import io.jacobking.localticket.core.utility.FileIO;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    public boolean initialized() throws IOException {
        if (!doesMainDirectoryExist()) {
            return false;
        }

        if (doesConfigFileExist()) {
            writeDefaultProperties(new File(ConfigCommons.CONFIG_DIRECTORY));
            return true;
        }

        return false;
    }

    private boolean doesMainDirectoryExist() {
        if (!FileIO.doesDirectoryExist(ConfigCommons.MAIN_DIRECTORY)) {
            return FileIO.createDirectory(ConfigCommons.MAIN_DIRECTORY);
        }
        return true;
    }

    private boolean doesConfigFileExist() {
        try {
            if (!FileIO.doesFileExist(ConfigCommons.CONFIG_DIRECTORY)) {
                return FileIO.createFile(ConfigCommons.CONFIG_DIRECTORY);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private void writeDefaultProperties(final File file) throws IOException {
        final Properties properties = new Properties();
        properties.load(new FileReader(ConfigCommons.CONFIG_DIRECTORY));
        properties.setProperty("database_url", "test");
        properties.setProperty("database_username", "");
        properties.setProperty("database_password", "");
        properties.setProperty("profile_url", "");
        properties.store(new FileWriter(file), null);
    }
}
