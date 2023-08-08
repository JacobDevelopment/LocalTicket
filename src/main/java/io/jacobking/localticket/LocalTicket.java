package io.jacobking.localticket;

import io.jacobking.localticket.core.proctor.StartupProctor;
import io.jacobking.localticket.database.DatabaseCore;
import io.jacobking.localticket.gui.ScreenHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class LocalTicket extends Application {
    @Override
    public void start(Stage stage) {
        ScreenHandler.getInstance().display("login");
    }

    public static void main(String[] args) {
        StartupProctor.getInstance();

        launch();
    }


}