package io.jacobking.localticket.gui;

import io.jacobking.localticket.gui.impl.DashboardScreen;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public final class ScreenHandler {

    private static final ScreenHandler instance = new ScreenHandler();
    private final Screen dashboard;

    private final Map<String, Screen> screenMap;

    private Screen currentScreen = null;

    private ScreenHandler() {
        this.screenMap = new HashMap<>();
        this.dashboard = new DashboardScreen();
        initialize();
    }

    public static ScreenHandler getInstance() {
        if (instance == null)
            return new ScreenHandler();
        return instance;
    }

    private void initialize() {
        put(dashboard);
    }

    private void put(final Screen screen) {
        screenMap.put(screen.getName(), screen);
    }

    public Screen get(final String name) {
        return screenMap.getOrDefault(name, null);
    }

    public void display(final String name) {
        System.out.println(name);
       final Screen screen = get(name.toLowerCase());
       if (screen == null) {
           System.out.println("screen is null");
           // TODO: Implement error handling.
           return;
       }

       if (currentScreen == screen)
           return;

       this.currentScreen = screen;
       currentScreen.initialize(new Stage());
    }

}
