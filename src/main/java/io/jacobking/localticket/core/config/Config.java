package io.jacobking.localticket.core.config;

import io.jacobking.localticket.core.utility.FileCommons;
import io.jacobking.localticket.core.utility.FileIO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private String databaseUrl;
    private boolean isFirstLaunch;

    private boolean isLoaded = false;

    public Config() {
        initialize();
    }

    private void initialize() {
        if (!FileIO.doesDirectoryExist(FileCommons.MAIN_DIRECTORY)) {
            System.out.println("MAIN_DIRECTORY does not exist.");
            System.out.println("Creating MAIN_DIRECTORY now.");
            FileIO.createDirectory(FileCommons.MAIN_DIRECTORY);
        }

        if (!FileIO.doesFileExist(FileCommons.CONFIG_PATH)) {
            System.out.println("SETTINGS.CONFIG does not exist.");
            System.out.println("Creating SETTINGS.CONFIG now.");
            handleCreatingConfigFile();
        }

        setAttributes();
    }

    private void handleCreatingConfigFile() {
        try {
            FileIO.createFile(FileCommons.CONFIG_PATH);
            final Properties properties = getProperties();
            FileIO.writeProperties(properties, FileCommons.CONFIG_PATH, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties getProperties() {
        final Properties properties = new Properties();
        properties.setProperty("database_url", "");
        properties.setProperty("first_launch", "true");
        return properties;
    }

    private void setAttributes() {
        final Properties properties = new Properties();
        try {
            properties.load(new FileReader(FileCommons.CONFIG_PATH));
            this.databaseUrl = properties.getProperty("database_url");
            this.isFirstLaunch = Boolean.parseBoolean(properties.getProperty("first_launch"));
            this.isLoaded = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateProperty(final String property, String newValue) {
        final Properties properties = new Properties();
        try {
            properties.load(new FileReader(FileCommons.CONFIG_PATH));
            properties.setProperty(property, newValue);
            FileIO.writeProperties(properties, FileCommons.CONFIG_PATH, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public boolean isFirstLaunch() {
        return isFirstLaunch;
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
