package io.jacobking.localticket.gui.impl;

import io.jacobking.localticket.gui.Screen;
import javafx.stage.Stage;

public class LoginScreen extends Screen {

    public LoginScreen() {
        super(258, 260, "login");
    }

    @Override
    protected void initialize(Stage stage) {
        configure(stage);
    }
}
