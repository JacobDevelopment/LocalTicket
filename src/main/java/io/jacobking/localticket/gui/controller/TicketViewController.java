package io.jacobking.localticket.gui.controller;

import io.jacobking.localticket.gui.ScreenHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TicketViewController {


    @FXML
    private void onOpenTicket() {

    }

    @FXML
    private void onDeleteTicket() {

    }

    @FXML
    private void onImportTicket() {

    }

    @FXML
    private void onExportTicket() {

    }

    @FXML
    private void onHelp() {

    }

    @FXML
    private void onCancel() {
        ScreenHandler.getInstance().close("ticket-viewer");
    }

}
