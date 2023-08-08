package io.jacobking.localticket.gui.controller;

import io.jacobking.jooq.tables.Security;
import io.jacobking.localticket.database.ConnectionPool;
import io.jacobking.localticket.database.Database;
import io.jacobking.localticket.gui.ScreenHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label warningLabel;

    @FXML
    private void onLogin() {
        final String username = usernameField.getText();
        if (username.isEmpty()) {
            usernameField.setBorder(Border.stroke(Color.RED));
            return;
        }

        final String password = passwordField.getText();
        if (password.isEmpty()) {
            passwordField.setBorder(Border.stroke(Color.RED));
            return;
        }

        if (isAuthenticated(username, password)) {
            ScreenHandler.getInstance().display("dashboard");
        } else {
            warningLabel.setText("Invalid credentials, please try again.");
        }
    }

    // TODO: Handle authentication.
    private boolean isAuthenticated(final String username, final String password) {
        if (!Database.getInstance().isLive())
            return false;
        return true;
    }

    @FXML
    private void onCancel() {
        System.exit(0);
    }

}
