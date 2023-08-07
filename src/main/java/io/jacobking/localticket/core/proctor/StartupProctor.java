package io.jacobking.localticket.core.proctor;

public class StartupProctor {

    private static final StartupProctor instance = new StartupProctor();

    private StartupProctor() {
        initialize();
    }

    private void initialize() {
        if (!ConfigProctor.getInstance().isInitialized()) {
            System.out.println("Config is not initialized.");
            return;
        }
    }

    public static StartupProctor getInstance() {
        if (instance == null)
            return new StartupProctor();
        return instance;
    }

}
