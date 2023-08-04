package io.jacobking.localticket.core.config;

import io.jacobking.localticket.core.utility.FileCommons;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Config instance = new Config();

    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;

    private String profilePath;

    private Config() {

    }

    public void initialize() throws IOException {
        final Properties properties = new Properties();
        properties.load(new FileReader(FileCommons.CONFIG_DIRECTORY));
        this.databaseUrl = properties.getProperty("database_url");
        this.databaseUsername = properties.getProperty("database_username");
        this.databasePassword = properties.getProperty("database_password");
        this.profilePath = properties.getProperty("profile_path");
    }

    public static Config getInstance() {
        if (instance == null)
            return new Config();
        return instance;
    }

    public String getDatabaseUrl() {
        final String changedUrl = this.databaseUrl.replaceAll("\\\\", "/");
        return String.format("jdbc:sqlite:%s", changedUrl);
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public String getProfilePath() {
        return profilePath;
    }
}
