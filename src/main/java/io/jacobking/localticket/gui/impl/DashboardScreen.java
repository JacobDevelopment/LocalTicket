package io.jacobking.localticket.gui.impl;

import io.jacobking.localticket.gui.Screen;
import io.jacobking.localticket.gui.ScreenHandler;
import javafx.stage.Stage;

public class DashboardScreen extends Screen {

    public DashboardScreen() {
        super(800, 400, "dashboard");
    }

    @Override
    public void initialize(Stage stage) {
        configure(stage);
    }

}
