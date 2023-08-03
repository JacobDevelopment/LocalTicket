package io.jacobking.localticket.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import javafx.scene.control.Tab;
import javafx.scene.shape.Circle;
import java.net.URL;

import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Label versionLabel;

    @FXML
    private Circle profilePictureCircle;

    @FXML
    private Tab ticketTab;

    @FXML
    private TicketController ticketController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void onProfile() {

    }

    @FXML
    private void onSettings() {
    }

    @FXML
    private void onExit() {
        System.exit(0);
    }


}
