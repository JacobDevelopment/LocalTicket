package io.jacobking.localticket.core.proctor;

import io.jacobking.localticket.core.config.Config;

public class ConfigProctor {

    private static final ConfigProctor instance = new ConfigProctor();

    private final Config config;
    private ConfigProctor() {
        this.config = new Config();
    }

    public static ConfigProctor getInstance() {
        if (instance == null)
            return new ConfigProctor();
        return instance;
    }

    public static Config get() {
        return getInstance().getConfig();
    }

    public boolean isInitialized() {
        return config.isLoaded();
    }

    private Config getConfig() {
        return config;
    }

}
