package io.jacobking.localticket;

import io.jacobking.localticket.gui.ScreenHandler;
import io.jacobking.localticket.gui.impl.DashboardScreen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LocalTicket extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ScreenHandler.getInstance().display("dashboard");
    }

    public static void main(String[] args) {
        launch();
    }
}