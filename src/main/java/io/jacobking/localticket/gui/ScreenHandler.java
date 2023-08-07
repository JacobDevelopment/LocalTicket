package io.jacobking.localticket.gui;

import io.jacobking.localticket.gui.impl.DashboardScreen;
import io.jacobking.localticket.gui.impl.LoginScreen;
import io.jacobking.localticket.gui.impl.TicketViewerScreen;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.HashMap;
import java.util.Map;

public final class ScreenHandler {

    private static final ScreenHandler instance = new ScreenHandler();

    private final Screen login;
    private final Screen dashboard;
    private final Screen ticketViewer;
    private final Map<String, Screen> screenMap;
    private Screen currentScreen = null;

    private ScreenHandler() {
        this.screenMap = new HashMap<>();
        this.login = new LoginScreen();
        this.dashboard = new DashboardScreen();
        this.ticketViewer = new TicketViewerScreen();
        initialize();
    }

    public static ScreenHandler getInstance() {
        if (instance == null)
            return new ScreenHandler();
        return instance;
    }

    private void initialize() {
        put(login);
        put(dashboard);
        put(ticketViewer);
    }

    private void put(final Screen screen) {
        screenMap.put(screen.getName(), screen);
    }

    public Screen get(final String name) {
        return screenMap.getOrDefault(name, null);
    }

    public void display(final String name) {
       final Screen screen = get(name.toLowerCase());
       if (screen == null) {
           return;
       }

       if (currentScreen != null) {
           close(currentScreen.getName());
       }

       this.currentScreen = screen;
       currentScreen.initialize(new Stage());
    }

    public void displayAsPopup(final String name) {
        final Screen screen = get(name.toLowerCase());
        if (screen == null) {
            return;
        }

        if (currentScreen == null) {
            return;
        }

        final Window window = currentScreen.getStage().getScene().getWindow();
        final Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(window);
        screen.initialize(stage);
    }

    public void close(final String name) {
        final Screen screen = get(name.toLowerCase());
        if (screen == null) {
            return;
        }

        screen.getStage().close();
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }
}
