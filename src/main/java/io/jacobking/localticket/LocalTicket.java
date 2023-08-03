package io.jacobking.localticket;

import io.jacobking.localticket.core.config.Config;
import io.jacobking.localticket.core.config.ConfigReader;
import io.jacobking.localticket.gui.ScreenHandler;
import io.jacobking.localticket.gui.impl.DashboardScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LocalTicket extends Application {
    @Override
    public void start(Stage stage) {
        ScreenHandler.getInstance().display("dashboard");
    }

    public static void main(String[] args) throws IOException {
        final ConfigReader configReader = new ConfigReader();
        if (!configReader.initialized()) {
            return;
        }
        Config.getInstance().initialize();

        launch();
    }
}