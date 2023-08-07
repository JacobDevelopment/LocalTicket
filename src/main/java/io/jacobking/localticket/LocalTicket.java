package io.jacobking.localticket;

import io.jacobking.localticket.database.Database;
import io.jacobking.localticket.gui.ScreenHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class LocalTicket extends Application {
    @Override
    public void start(Stage stage) {
        ScreenHandler.getInstance().display("login");
    }

    public static void main(String[] args) throws IOException {
        launch();
    }


}